package com.samsam.bsl.notice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private ReviewRepository reviewRepository;

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
				.createdAt(notice.getCreatedAt())
				.modifiedAt(notice.getModifiedAt())
				.nickname(notice.getUser().getNickname())
				.build();
	}
	
	//리뷰목록조회, 검색
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

	// 리뷰작성
	@Transactional
	public Integer savePost(NoticeDTO noticeDTO) {
		return noticeRepository.save(noticeDTO.toEntity()).getNot_postId();
	}

	public List<ReviewDTO> getReviewsPerPage(int perPage, int pageNum) {
		Pageable pageable = PageRequest.of(pageNum - 1, perPage, Sort.by(Sort.Direction.ASC, "createdAt"));
		Page<Review> page = reviewRepository.findAll(pageable);
//		List<ReviewDTO> reviews = page.map(this::convertEntityToDto).getContent();
//		return reviews;
		return null;
	}

	@Transactional
	public Long getReviewCount() {
		return reviewRepository.count();
	}

	@Transactional
	public ReviewDTO getPost(Integer rev_postId) {
		Optional<Review> reviewWrapper = reviewRepository.findById(rev_postId);
		Review review = reviewWrapper.get();

//		return this.convertEntityToDto(review);
		return null;
	}

	@Transactional
	public void deletePost(Integer rev_postId) {
		reviewRepository.deleteById(rev_postId);
	}

	@Transactional
	public void updateReview(ReviewDTO reviewDTO) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewDTO.getRev_postId());

		if (optionalReview.isPresent()) {
			Review review = optionalReview.get();

			// 리뷰 업데이트에 필요한 정보를 ReviewDTO에서 가져와서 업데이트
			review.setPostTitle(reviewDTO.getPostTitle());
			review.setRate(reviewDTO.getRate());
			review.setContent(reviewDTO.getContent());
			review.setBookNo(reviewDTO.getBookNo());
			review.setCreatedAt(reviewDTO.getCreatedAt());
			review.setModifiedAt(reviewDTO.getModifiedAt());
			review.setIsbn(reviewDTO.getIsbn());
//	        review.setBookImageURL(reviewDTO.getBookImageURL());
//	        review.setBookname(reviewDTO.getBookname());
//	        review.setAuthor(reviewDTO.getAuthor());
//	        review.setPublisher(reviewDTO.getPublisher());
//	        review.setCallNum(reviewDTO.getCallNum());
//	        review.setShelfArea(reviewDTO.getShelfArea());

			// ReviewRepository를 사용하여 업데이트
			reviewRepository.save(review);
		}
	}
}
