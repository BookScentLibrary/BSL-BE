package com.samsam.bsl.mypage.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.mypage.dto.CountDTO;
import com.samsam.bsl.mypage.dto.ReviewDTO;
import com.samsam.bsl.mypage.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/mypage")
public class MyPageController {

  @Autowired
  MyPageService myPageService;
  @GetMapping("/count")
  public ResponseEntity<?> getRentCound(@RequestParam String userId) {
    try{
    CountDTO result = myPageService.getCount(userId);
    return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }
  
  @GetMapping("/review")
  public ResponseEntity<?> getReviews(@RequestParam String userId) {
    try {
      List<Review> reviews = myPageService.getReviews(userId);
      return ResponseEntity.status(HttpStatus.OK).body(reviews);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다. ");
    }
  }

  @GetMapping("/review/main")
  public ResponseEntity<?> getReviewMain(@RequestParam String userId) {
    try {
      List<Review> reviews = myPageService.getReviewMain(userId);
      return ResponseEntity.status(HttpStatus.OK).body(reviews);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다. ");
    }
  }

  @GetMapping("/rent/history")
  public ResponseEntity<?> getRentHistoryMain(@RequestParam String userId) {
    try {
      List<RentHistory> rentHistory = myPageService.getRentHistoryMain(userId);
      return ResponseEntity.status(HttpStatus.OK).body(rentHistory);
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @PostMapping("/book/list")
  public ResponseEntity<?> getBookList(@RequestBody List<Integer> bookNos) {
    try {
      List<Book> books = myPageService.getBookList(bookNos);
      return ResponseEntity.status(HttpStatus.OK).body(books);
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

}
