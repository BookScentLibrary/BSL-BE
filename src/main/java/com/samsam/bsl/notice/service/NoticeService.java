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

	@Transactional
	public List<NoticeDTO> getNoticeList() {
		List<Notice> notices = noticeRepository.getAllNotices();
		List<NoticeDTO> noticeDTOList = new ArrayList<>();
		for (Notice notice : notices) {
			noticeDTOList.add(this.convertEntityToDto(notice));
		}

		return noticeDTOList;
	}

	private NoticeDTO convertEntityToDto(Notice notice) {
		return NoticeDTO.builder().userId(notice.getUserId()).not_postId(notice.getNot_postId())
				.postTitle(notice.getPostTitle()).content(notice.getContent()).postImgURL(notice.getPostImgURL())
				.createdAt(notice.getCreatedAt()).modifiedAt(notice.getModifiedAt())
				.nickname(notice.getUser().getNickname()).build();
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

		return notices.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	// 공지사항작성
	@Transactional
	public Integer savePost(NoticeDTO noticeDTO) {
		return noticeRepository.save(noticeDTO.toEntity()).getNot_postId();
	}

//	@Value("${file.upload-dir}")
//	private String uploadDir;
//
//	public String uploadImage(MultipartFile file) {
//		if (file == null || file.isEmpty()) {
//			// 이미지 파일이 전달되지 않은 경우 null 반환
//			return null;
//		}
//
//		try {
//			// 이미지 파일을 업로드 디렉토리에 저장
//			String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//			File dest = new File(uploadDir, filename);
//			file.transferTo(dest);
//
//			// 업로드한 이미지 파일의 URL을 생성하여 반환
//			String imageUrl = "/images/" + filename;
//			return imageUrl;
//		} catch (IOException e) {
//			e.printStackTrace();
//			// 업로드 실패 시 null 반환
//			return null;
//		}
//	}
//
//	@PostConstruct
//	public void init() {
//		// 파일 업로드 디렉토리가 없을 경우 디렉토리 생성
//		File directory = new File(uploadDir);
//		if (!directory.exists()) {
//			directory.mkdirs();
//		}
//	}

	// 공지사항 상세보기
	@Transactional
	public NoticeDTO getPost(Integer not_postId) {
		Optional<Notice> noticeWrapper = noticeRepository.findById(not_postId);
		Notice notice = noticeWrapper.get();

		return this.convertEntityToDto(notice);
	}

	//공지사항 수정
	@Transactional
	public void updateNotice(NoticeDTO noticeDTO) {
		Optional<Notice> optionalNotice = noticeRepository.findById(noticeDTO.getNot_postId());

		if (optionalNotice.isPresent()) {
			Notice notice = optionalNotice.get();

			// 공지사항 업데이트에 필요한 정보를 NoticeDTO에서 가져와서 업데이트
			notice.setPostTitle(noticeDTO.getPostTitle());
			notice.setContent(noticeDTO.getContent());
			notice.setPostImgURL(noticeDTO.getPostImgURL());
			notice.setCreatedAt(noticeDTO.getCreatedAt());
			notice.setModifiedAt(noticeDTO.getModifiedAt());

			// NoticeRepository를 사용하여 업데이트
			noticeRepository.save(notice);
		}
	}

	//공지사항 삭제
	@Transactional
	public void deletePost(Integer not_postId) {
		noticeRepository.deleteById(not_postId);
	}

}
