package com.samsam.bsl.notice.service;

import java.io.File;
import java.io.IOException;
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
import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.notice.domain.Notice;
import com.samsam.bsl.notice.dto.NoticeDTO;
import com.samsam.bsl.notice.repository.NoticeRepository;

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
			NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId())
					.userId(notice.getUserId())
					.postTitle(notice.getPostTitle())
					.content(notice.getContent()).postImgURL(notice.getPostImgURL()).imgId(notice.getImgId())
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
	public List<NoticeDTO> getNoticeList() {
		List<Notice> noticeList = noticeRepository.findAll();
		List<NoticeDTO> noticeDtoList = new ArrayList<>();

		for (Notice notice : noticeList) {
			NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId()).userId(notice.getUserId())
					.postTitle(notice.getPostTitle())
					.content(notice.getContent())
					//.postImgURL(notice.getPostImgURL())
					//.imgId(notice.getImgId())
					.createdAt(notice.getCreatedAt())
					.nickname(notice.getUser().getNickname())
					.build();
			noticeDtoList.add(noticeDTO);
		}
		return noticeDtoList;
	}

	@Transactional
	public NoticeDTO getNotice(int not_postId) {
		Notice notice = noticeRepository.findById(not_postId).get();

		NoticeDTO noticeDTO = NoticeDTO.builder().not_postId(notice.getNot_postId()).userId(notice.getUserId())
				.postTitle(notice.getPostTitle()).content(notice.getContent()).postImgURL(notice.getPostImgURL())
				.imgId(notice.getImgId()).createdAt(notice.getCreatedAt()).build();
		return noticeDTO;
	}

	@Transactional
	public void deletePost(int not_postId) {
		noticeRepository.deleteById(not_postId);
	}

}
