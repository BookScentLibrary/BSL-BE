package com.samsam.bsl.notice.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.dto.ReviewRequestDTO;
import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.notice.domain.Notice;
import com.samsam.bsl.notice.dto.NoticeDTO;
import com.samsam.bsl.notice.dto.NoticeRequestDTO;
import com.samsam.bsl.notice.repository.NoticeRepository;
import java.io.File;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

	// 공지사항록조회, 검색
	@Transactional
	public List<NoticeDTO> searchPosts(String keyword, String searchType) {
		List<Notice> notices = new ArrayList<>();

		if ("all".equals(searchType)) {
			notices = noticeRepository.findByPostTitleContainingOrContentContaining(keyword, keyword);
		} else if ("postTitle".equals(searchType)) {
			notices = noticeRepository.findByPostTitleContaining(keyword);
		} else if ("content".equals(searchType)) {
			notices = noticeRepository.findByContentContaining(keyword);
		}

		List<NoticeDTO> noticeDtoList = new ArrayList<>();
		for (Notice notice : notices) {
			NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId()).userId(notice.getUserId())
					.postTitle(notice.getPostTitle()).content(notice.getContent()).postImgURL(notice.getPostImgURL())
					.createdAt(notice.getCreatedAt()).build();
			noticeDtoList.add(noticeDTO);
		}
		return noticeDtoList;
	}

	@Transactional
	public int savePost(NoticeDTO noticeDTO) {
		return noticeRepository.save(noticeDTO.toEntity()).getNot_postId();
	}

	@Transactional
	public int savePost(NoticeRequestDTO noticeRequestDTO) {
		Notice notice = new Notice();
		notice.setPostTitle(noticeRequestDTO.getPostTitle());
		notice.setContent(noticeRequestDTO.getContent());
		notice.setUserId(noticeRequestDTO.getUserId());
		notice.setPostImgURL(noticeRequestDTO.getPostImgURL());

		try {
			noticeRepository.save(notice);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	public NoticeDTO updateNotice(int not_postId, NoticeDTO updatedNoticeDTO) {
		Notice existingNotice = noticeRepository.findById(not_postId).get();

		// 업데이트된 데이터로 업데이트
		existingNotice.setPostTitle(updatedNoticeDTO.getPostTitle());
		existingNotice.setContent(updatedNoticeDTO.getContent());
		existingNotice.setPostImgURL(updatedNoticeDTO.getPostImgURL());
		existingNotice.setModifiedAt(LocalDateTime.now()); // modifiedAt 업데이트

		// 저장
		noticeRepository.save(existingNotice);

		// 업데이트된 공지사항 정보 반환
		return NoticeDTO.builder().not_postId(existingNotice.getNot_postId()).userId(existingNotice.getUserId())
				.postTitle(existingNotice.getPostTitle()).content(existingNotice.getContent())
				.postImgURL(existingNotice.getPostImgURL()).createdAt(existingNotice.getCreatedAt())
				.modifiedAt(existingNotice.getModifiedAt()).build();
	}

	@Transactional
	public List<NoticeDTO> getNoticeList() {
		List<Notice> noticeList = noticeRepository.findAll();
		List<NoticeDTO> noticeDtoList = new ArrayList<>();

		for (Notice notice : noticeList) {
			NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId()).userId(notice.getUserId())
					.postTitle(notice.getPostTitle()).content(notice.getContent())
					.createdAt(notice.getCreatedAt()).nickname(notice.getUser().getNickname()).build();
			noticeDtoList.add(noticeDTO);
		}
		return noticeDtoList;
	}

	@Transactional
	public NoticeDTO getNotice(int not_postId) {
		Notice notice = noticeRepository.findById(not_postId).get();

		NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId()).userId(notice.getUserId())
				.postTitle(notice.getPostTitle()).content(notice.getContent()).postImgURL(notice.getPostImgURL())
				.createdAt(notice.getCreatedAt()).build();
		return noticeDTO;
	}

	@Transactional
	public void deletePost(int not_postId) {
		noticeRepository.deleteById(not_postId);
	}

}
