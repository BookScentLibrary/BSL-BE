package com.samsam.bsl.mypage.service;

import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.book.rent.repository.ReturnRepository;
import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.mypage.dto.CountDTO;
import com.samsam.bsl.mypage.dto.ReviewDTO;
import com.samsam.bsl.mypage.repository.MyPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPageService {

  @Autowired
  RentRepository rentRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  ReturnRepository returnRepository;

  @Autowired
  ReviewRepository reviewRepository;

  @Autowired
  MyPageRepository myPageRepository;


  public CountDTO getCount(String userId) {
    try {
      Long rentCnt = returnRepository.countByUserId(userId);
      Long reviewCnt = reviewRepository.countByUserId(userId);
//      Long programCnt = programRepository.countByUserId(userId);
      CountDTO cnt = new CountDTO(rentCnt, reviewCnt);
      return cnt;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<ReviewDTO> getReviews(String userId) {
    try {
      return myPageRepository.getMyReviews(userId);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}

