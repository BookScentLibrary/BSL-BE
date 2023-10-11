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

import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.service.ReviewService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/reviewList")
	public ResponseEntity<List<ReviewDTO>> handleReviewListRequest(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "searchType", defaultValue = "all") String searchType) {

		// keyword 파라미터가 있을 경우 검색 동작을 수행
		if (keyword != null && !keyword.isEmpty()) {
			List<ReviewDTO> reviewDTOList = reviewService.searchPosts(keyword, searchType);

			if (reviewDTOList.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(reviewDTOList);
			}
		} else {
			// keyword 파라미터가 없을 경우 모든 리뷰를 불러오는 동작을 수행
			List<ReviewDTO> allReviewDTOList = reviewService.getReviewList();

			if (allReviewDTOList.isEmpty()) {
				return ResponseEntity.noContent().build(); 
			} else {
				return ResponseEntity.ok(allReviewDTOList);
			}
		}
	}

//	@GetMapping("/reviewList")
//	public ResponseEntity<Page<ReviewDTO>> handleReviewListRequest(
//	        @RequestParam(value = "keyword", required = false) String keyword,
//	        @RequestParam(value = "searchType", defaultValue = "all") String searchType,
//	        @RequestParam(value = "perPage", defaultValue = "20") int perPage,
//	        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
//
//	    // 페이지 번호는 1 이상이어야 함
//	    if (pageNum < 1) {
//	        pageNum = 1;
//	    }
//
//	    // Pageable 객체 생성
//	    Pageable pageable = PageRequest.of(pageNum - 1, perPage, Sort.by(Sort.Direction.DESC, "createdAt"));
//
//	    // 검색 조건에 따라 리뷰 목록 가져오기
//	    Page<ReviewDTO> reviewDTOPage = reviewService.searchPosts(keyword, searchType, pageable);
//
//	    // 검색 결과가 없는 경우
//	    if (reviewDTOPage.isEmpty()) {
//	        return ResponseEntity.noContent().build();
//	    }
//
//	    return ResponseEntity.ok(reviewDTOPage);
//	}

	// 리뷰상세보기
	@GetMapping("/reviewDetail/{rev_postId}")
	public ResponseEntity<ReviewDTO> detail(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

//	@GetMapping("/reviewWrite")
//	public ResponseEntity<String> write() {
//		// Write logic here
//		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
//	}

	// 리뷰쓰기
	@PostMapping("/reviewWrite")
	public ResponseEntity<Void> write(@RequestBody ReviewDTO reviewDTO) {
		reviewService.savePost(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	@PostMapping("/reviewWrite")
//  public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
//      // 현재 로그인한 사용자의 ID(username)를 가져옴
//      String username = SecurityContextHolder.getContext().getAuthentication().getName();
//      
//      ReviewDTO createdReview = reviewService.createReview(reviewDTO, username);
//      
//      if (createdReview != null) {
//          return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
//      } else {
//          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//  }

	// 엥머지왜 수정이 두개지
	@GetMapping("/news/reviewEdit/{rev_postId}")
	public ResponseEntity<ReviewDTO> edit(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

	// 리뷰수정
	@PutMapping("/news/reviewEdit/{rev_postId}")
	public ResponseEntity<Void> update(@PathVariable("rev_postId") Integer rev_postId,
			@RequestBody ReviewDTO reviewDTO) {
		// Update logic here
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	// 리뷰삭제
	@DeleteMapping("/news/ReviewDelete/{rev_postId}/")
	public ResponseEntity<Void> delete(@PathVariable("rev_postId") Integer rev_postId) {
		reviewService.deletePost(rev_postId);
		return ResponseEntity.noContent().build();
	}

}