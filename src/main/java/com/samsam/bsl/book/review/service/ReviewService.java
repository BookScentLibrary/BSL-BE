package com.samsam.bsl.book.review.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.dto.ReviewRequestDTO;
import com.samsam.bsl.book.review.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional
	public List<Review> getReviewList() {
		return reviewRepository.getAllReviews();
	}

	private ReviewDTO convertEntityToDto(Review review) {
		return ReviewDTO.builder().userId(review.getUserId()).bookNo(review.getBookNo())
				.rev_postId(review.getRev_postId()).postTitle(review.getPostTitle()).content(review.getContent())
				.createdAt(review.getCreatedAt()).modifiedAt(review.getModifiedAt()).isbn(review.getIsbn())
				.rate(review.getRate()).nickname(review.getUser().getNickname())
				.bookname(review.getBook().getBookname()).bookImageURL(review.getBook().getBookImageURL())
				.author(review.getBook().getAuthor()).publisher(review.getBook().getPublisher())
				.callNum(review.getBook().getCallNum()).shelfArea(review.getBook().getShelfArea()).build();
	}

	@Transactional
	public ReviewDTO getPost(Integer rev_postId) {
		Optional<Review> reviewWrapper = reviewRepository.findById(rev_postId);
		Review review = reviewWrapper.get();

		return this.convertEntityToDto(review);
	}

	@Transactional
	public int savePost(ReviewRequestDTO reviewRequestDTO) {
		Review review = new Review();
		review.setPostTitle(reviewRequestDTO.getPostTitle());
		review.setContent(reviewRequestDTO.getContent());
		review.setBookNo(reviewRequestDTO.getBookNo());
		review.setUserId(reviewRequestDTO.getUserId());
		review.setRate(reviewRequestDTO.getRate());
		review.setIsbn(reviewRequestDTO.getIsbn());

		try {
			reviewRepository.save(review);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	public void deletePost(Integer rev_postId) {
		reviewRepository.deleteById(rev_postId);
	}

	@Transactional
	public List<Review> searchPosts(String keyword, String searchType) {
		if ("all".equals(searchType)) {
			return reviewRepository
					.findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
							keyword, keyword, keyword, keyword, keyword, keyword);
		} else if ("bookname".equals(searchType)) {
			return reviewRepository.findByBook_booknameContaining(keyword);
		} else if ("postTitle".equals(searchType)) {
			return reviewRepository.findByPostTitleContaining(keyword);
		} else if ("author".equals(searchType)) {
			return reviewRepository.findByBook_authorContaining(keyword);
		} else if ("publisher".equals(searchType)) {
			return reviewRepository.findByBook_publisherContaining(keyword);
		} else if ("callNum".equals(searchType)) {
			return reviewRepository.findByBook_callNumContaining(keyword);
		} else if ("publicationYear".equals(searchType)) {
			return reviewRepository.findByBook_publicationYearContaining(keyword);
		}

		return Collections.emptyList();
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

			// ReviewRepository를 사용하여 업데이트
			reviewRepository.save(review);
		}
	}

}