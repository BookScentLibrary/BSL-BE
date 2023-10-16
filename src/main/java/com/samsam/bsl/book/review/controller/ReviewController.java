package com.samsam.bsl.book.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.samsam.bsl.book.review.dto.CommentDTO;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.dto.ReviewRequestDTO;
import com.samsam.bsl.book.review.service.ReviewService;
import com.samsam.bsl.notice.dto.NoticeDTO;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// 리뷰가져옴
//	@GetMapping("/reviewList")
//	public ResponseEntity<List<ReviewDTO>> handleReviewListRequest(
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "searchType", defaultValue = "all") String searchType) {
//
//		// keyword 파라미터가 있을 경우 검색 동작을 수행
//		if (keyword != null && !keyword.isEmpty()) {
//			List<ReviewDTO> reviewDTOList = reviewService.searchPosts(keyword, searchType);
//
//			if (reviewDTOList.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			} else {
//				return ResponseEntity.ok(reviewDTOList);
//			}
//		} else {
//			// keyword 파라미터가 없을 경우 모든 리뷰를 불러오는 동작을 수행
//			List<ReviewDTO> allReviewDTOList = reviewService.getReviewList();
//
//			if (allReviewDTOList.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			} else {
//				return ResponseEntity.ok(allReviewDTOList);
//			}
//		}
//	}
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

	// 리뷰쓰기
//	@PostMapping("/reviewWrite")
//	public ResponseEntity<Void> write(@RequestBody ReviewDTO reviewDTO) {
//		reviewService.savePost(reviewDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}
	@PostMapping("/reviewWrite")
	public ResponseEntity<?> writeReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
		// 이제 ReviewRequestDTO를 사용하여 게시물 작성
		System.out.println(reviewRequestDTO.toString());
		int result = reviewService.savePost(reviewRequestDTO);

		if (result == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패");
		}
	}

//	public ResponseEntity<Void> write(@RequestBody ReviewDTO reviewDTO) {
//		reviewService.savePost(reviewDTO);
//		reviewService.updateRatingData(reviewDTO.getBookNo(), reviewDTO.getRate());
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

//	@GetMapping("/reviewEdit/{rev_postId}")
//	public ResponseEntity<ReviewDTO> edit(@PathVariable("rev_postId") Integer rev_postId) {
//		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
//		return ResponseEntity.ok(reviewDTO);
//	}

	// @PutMapping("/reviewEdit/{rev_postId}")
//	public ResponseEntity<Void> updateReview(@PathVariable Integer rev_postId, @RequestBody ReviewDTO reviewDTO) {
//	    reviewService.modify(reviewDTO); // 1번에서 정의한 수정 메서드 호출
//	    return ResponseEntity.ok().build(); // 업데이트 성공 시 200 OK 응답 반환
//	}
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

	// 댓글작성
//	@PostMapping("/reviewDetail/{rev_postId}")
//	public ResponseEntity<Void> writeComment(@RequestBody CommentDTO commentDTO) {
//		reviewService.saveComment(commentDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

//	// 댓글수정
//	@PutMapping("/reviewDetail/{rev_postId}")
//	public ResponseEntity<Void> updateComment(@PathVariable("commentId") Integer commentId,
//			@RequestBody CommentDTO commentDTO) {
//		commentDTO.setCommentId(commentId);
//		reviewService.updateComment(commentDTO); // 공지사항 수정 서비스 호출
//		return ResponseEntity.ok().build();
//	}
//
//	// 댓글삭제
//	@DeleteMapping("/reviewDetail/{rev_postId}")
//	public ResponseEntity<Void> deleteComment(@PathVariable("commentId") Integer commentId) {
//		reviewService.deleteComment(commentId);
//		return ResponseEntity.noContent().build();
//	}

}