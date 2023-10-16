package com.samsam.bsl.mypage.controller;


import com.samsam.bsl.mypage.dto.CountDTO;
import com.samsam.bsl.mypage.dto.ReviewDTO;
import com.samsam.bsl.mypage.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/mypage")
public class MyPageController {

  @Autowired
  MyPageService myPageService;
  @GetMapping("/book/count/{userId}")
  public ResponseEntity<?> getRentCound(@PathVariable String userId) {
    try{
    CountDTO result = myPageService.getCount(userId);
    return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }
  
  @GetMapping("/review/{userId}")
  public ResponseEntity<?> getReviews(@PathVariable String userId) {
    try {
      List<ReviewDTO> reviews = myPageService.getReviews(userId);
      return ResponseEntity.status(HttpStatus.OK).body(reviews);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다. ");
    }
  }

}
