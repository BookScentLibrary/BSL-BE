package com.samsam.bsl.mainpage.controller;

import com.samsam.bsl.mainpage.dto.*;
import com.samsam.bsl.mainpage.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

  @Autowired
  MainService mainService;

  @GetMapping("/newbook")
  public ResponseEntity<?> getNewBooks() {
    try {
      List<MainBook> result = mainService.getNewBook();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @GetMapping("/notice")
  public ResponseEntity<?> getNotice() {
    try {
      List<MainNotice> result = mainService.getNotice();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @GetMapping("/program")
  public ResponseEntity<?> getProgram() {
    try {
      List<MainProgram> result = mainService.getProgram();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @GetMapping("/bestseller")
  public ResponseEntity<?> getBestseller() {
    try {
      List<MainBook> result = mainService.getBestseller();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @GetMapping("/recommend")
  public ResponseEntity<?> getRecommend() {
    try {
      List<MainRecomm> result = mainService.getRecommend();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }

  @GetMapping("/review")
  public ResponseEntity<?> getReview() {
    try {
      List<MainReview> result = mainService.getReview();
      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
    }
  }
}
