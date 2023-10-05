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

@CrossOrigin(originPatterns="http://localhost:3000")
@RestController
@RequestMapping("/news/ReviewList")
public class ReviewController {
	
    @Autowired
    private ReviewService reviewService;
    
    @GetMapping
    public List<ReviewDTO> getReviewListWithUserInfo() {
        return reviewService.getAllReviewsWithUserInfo();
    }
    
    @GetMapping("/ReviewListPerPage")
    public ResponseEntity<List<ReviewDTO>> getReviews(
            @RequestParam(defaultValue = "20") int perPage,
            @RequestParam(defaultValue = "1") int pageNum) {
        List<ReviewDTO> reviews = reviewService.getReviewsPerPage(perPage, pageNum);
        return ResponseEntity.ok(reviews);
    }
    
    @GetMapping("/ReviewDetail/{rev_postId}")
	public ResponseEntity<ReviewDTO> detail(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}
    
    @GetMapping("/news/ReviewWrite")
	public ResponseEntity<String> write() {
		// Write logic here
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
    
    @PostMapping("/news/ReviewWrite")
	public ResponseEntity<Void> write(@RequestBody ReviewDTO reviewDTO) {
		reviewService.savePost(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
    
    @GetMapping("/news/ReviewEdit/{rev_postId}")
	public ResponseEntity<ReviewDTO> edit(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}
    
    @PutMapping("/news/ReviewEdit/{rev_postId}")
	public ResponseEntity<Void> update(@PathVariable("rev_postId") Integer rev_postId,
			@RequestBody ReviewDTO reviewDTO) {
		// Update logic here
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
    
    @DeleteMapping("/news/ReviewDelete/{rev_postId}/")
	public ResponseEntity<Void> delete(@PathVariable("rev_postId") Integer rev_postId) {
		reviewService.deletePost(rev_postId);
		return ResponseEntity.noContent().build();
	}


}