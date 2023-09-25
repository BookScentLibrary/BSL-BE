package com.samsam.bsl.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ReviewController {
//
//	@Autowired
//	private ReviewService reviewService;
//
//	@GetMapping("/")
//	public List<Review> getAllReviews() {
//		return reviewService.getAllReviews();
//	}
//
//	@PostMapping("/create")
//	public ResponseEntity<?> createReview(@RequestBody Review review) {
//		// 리뷰 생성 로직
//		return ResponseEntity.ok("Review created successfully");
//	}
//
//	@PostMapping("/searchBook")
//	public String searchBook(@RequestParam("bookTitle") String bookTitle, Model model) {
//		// 책 검색 로직을 수행하여 검색 결과를 가져옵니다. (BookService와 연계)
//		List<Book> searchResults = bookService.searchBooksByTitle(bookTitle);
//		model.addAttribute("searchResults", searchResults);
//		return "search-book-results"; // 검색 결과 페이지로 이동
//	}
//
//	@PostMapping("/create")
//	public String createReview(@ModelAttribute("review") PostReviewDTO review) {
//		// 별점 정보를 저장
//		int rating = review.getRating();
//		// 리뷰 작성 페이지에서 작성한 리뷰를 저장
//		reviewService.createReview(review);
//		return "redirect:/review/list";
//	}
//
}
