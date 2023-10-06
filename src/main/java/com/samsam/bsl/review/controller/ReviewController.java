package com.samsam.bsl.review.controller;

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

import com.samsam.bsl.review.dto.ReviewDTO;
import com.samsam.bsl.review.service.ReviewService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

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
//			List<ReviewDTO> allReviewDTOList = reviewService.getAllReviewsWithUserInfo();
//
//			if (allReviewDTOList.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			} else {
//				return ResponseEntity.ok(allReviewDTOList);
//			}
//		}
//	}
	
	@GetMapping("/reviewList")
	public ResponseEntity<List<ReviewDTO>> handleReviewListRequest(
	        @RequestParam(value = "keyword", required = false) String keyword,
	        @RequestParam(value = "searchType", defaultValue = "all") String searchType) {

	    // keyword 파라미터가 있을 경우 검색 동작을 수행
	    if (keyword != null && !keyword.isEmpty()) {
	        List<ReviewDTO> reviewDTOList = reviewService.searchPosts(keyword, searchType);

	        if (reviewDTOList.isEmpty()) {
	            System.out.println("검색 결과가 없습니다.");
	            return ResponseEntity.noContent().build();
	        } else {
	            System.out.println("검색 결과:");
	            for (ReviewDTO reviewDTO : reviewDTOList) {
	                System.out.println("리뷰 제목: " + reviewDTO.getPostTitle());
	                System.out.println("작성자 닉네임: " + reviewDTO.getNickname());
	                System.out.println("책이름: " + reviewDTO.getBookname());
	                System.out.println("아이디: " + reviewDTO.getUserId());
	                System.out.println("책번호: " + reviewDTO.getBookNo());
	                System.out.println("리뷰내용: " + reviewDTO.getContent());
	                System.out.println("리뷰번호: " + reviewDTO.getRev_postId());
	                System.out.println("리뷰생성날짜: " + reviewDTO.getCreatedAt());
	                System.out.println("리뷰수정날짜: " + reviewDTO.getModifiedAt());
	                System.out.println("isbn: " + reviewDTO.getIsbn());
	                System.out.println("평점: " + reviewDTO.getRate());
	                // 필요한 정보를 추가로 출력할 수 있습니다.
	            }
	            return ResponseEntity.ok(reviewDTOList);
	        }
	    } else {
	        // keyword 파라미터가 없을 경우 모든 리뷰를 불러오는 동작을 수행
	        List<ReviewDTO> allReviewDTOList = reviewService.getAllReviewsWithUserInfo();

	        if (allReviewDTOList.isEmpty()) {
	            System.out.println("리뷰가 없습니다.");
	            return ResponseEntity.noContent().build();
	        } else {
	            System.out.println("모든 리뷰:");
	            for (ReviewDTO reviewDTO : allReviewDTOList) {
	                System.out.println("리뷰 제목: " + reviewDTO.getPostTitle());
	                System.out.println("작성자 닉네임: " + reviewDTO.getNickname());
	                System.out.println("책이름: " + reviewDTO.getBookname());
	                System.out.println("아이디: " + reviewDTO.getUserId());
	                System.out.println("책번호: " + reviewDTO.getBookNo());
	                System.out.println("리뷰내용: " + reviewDTO.getContent());
	                System.out.println("리뷰번호: " + reviewDTO.getRev_postId());
	                System.out.println("리뷰생성날짜: " + reviewDTO.getCreatedAt());
	                System.out.println("리뷰수정날짜: " + reviewDTO.getModifiedAt());
	                System.out.println("isbn: " + reviewDTO.getIsbn());
	                System.out.println("평점: " + reviewDTO.getRate());
	                // 필요한 정보를 추가로 출력할 수 있습니다.
	            }
	            return ResponseEntity.ok(allReviewDTOList);
	        }
	    }
	}


//    @GetMapping("/reviewList")
//    public List<ReviewDTO> getReviewListWithUserInfo() {
//        return reviewService.getAllReviewsWithUserInfo();
//    }//여기까지 모든리뷰와 nickname, bookname 가져오는데 필요한 메서드

	@GetMapping("/ReviewListPerPage")
	public ResponseEntity<List<ReviewDTO>> getReviews(@RequestParam(defaultValue = "20") int perPage,
			@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "createdAt") String sortBy) {
		List<ReviewDTO> reviews = reviewService.getReviewsPerPage(pageNum, perPage, sortBy);
		return ResponseEntity.ok(reviews);
	}

	// 리뷰상세보기
	@GetMapping("/ReviewDetail/{rev_postId}")
	public ResponseEntity<ReviewDTO> detail(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

	@GetMapping("/reviewWrite")
	public ResponseEntity<String> write() {
		// Write logic here
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	// 리뷰쓰기
	@PostMapping("/reviewWrite")
	public ResponseEntity<Void> write(@RequestBody ReviewDTO reviewDTO) {
		reviewService.savePost(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// 엥머지왜 수정이 두개지
	@GetMapping("/news/ReviewEdit/{rev_postId}")
	public ResponseEntity<ReviewDTO> edit(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

	// 리뷰수정
	@PutMapping("/news/ReviewEdit/{rev_postId}")
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

	// 리뷰검색
//	@GetMapping("/reviewList")
//	public ResponseEntity<List<ReviewDTO>> search(@RequestParam(value = "keyword") String keyword,
//			@RequestParam(value = "searchType", defaultValue = "all") String searchType) {
//		List<ReviewDTO> reviewDTOList = reviewService.searchPosts(keyword, searchType);
//
//		if (reviewDTOList.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		} else {
//			return ResponseEntity.ok(reviewDTOList);
//		}
//	}

}