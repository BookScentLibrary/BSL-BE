package com.samsam.bsl.book.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.dto.ReviewRequestDTO;
import com.samsam.bsl.book.review.service.ReviewService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/reviewList")
	public ResponseEntity<List<Review>> handleReviewListRequest(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "searchType", defaultValue = "all") String searchType) {
		List<Review> reviewList;

		if (keyword != null && !keyword.isEmpty()) {
			reviewList = reviewService.searchPosts(keyword, searchType);
		} else {
			reviewList = reviewService.getReviewList();
		}

		if (reviewList.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reviewList);
		}
	}

	// 리뷰상세보기
	@GetMapping("/reviewDetail/{rev_postId}")
	public ResponseEntity<ReviewDTO> detail(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

	@PostMapping("/reviewWrite")
	public ResponseEntity<?> writeReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
		// 이제 ReviewRequestDTO를 사용하여 게시물 작성
		int result = reviewService.savePost(reviewRequestDTO);

		if (result == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패");
		}
	}

	// 리뷰수정
	@PutMapping("/reviewEdit/{rev_postId}")
	public ResponseEntity<Void> update(@PathVariable("rev_postId") Integer rev_postId,
			@RequestBody ReviewDTO reviewDTO) {
		reviewDTO.setRev_postId(rev_postId); // 리뷰 ID 설정
		reviewService.updateReview(reviewDTO); // 리뷰 수정 서비스 호출
		return ResponseEntity.ok().build();
	}

	// 리뷰삭제
	@DeleteMapping("/reviewDetail/{rev_postId}")
	public ResponseEntity<Void> delete(@PathVariable("rev_postId") Integer rev_postId) {
		reviewService.deletePost(rev_postId);
		return ResponseEntity.noContent().build();
	}

}