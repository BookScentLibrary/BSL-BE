package com.samsam.bsl.mypage.repository.querydsl;

import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.mypage.dto.ReviewDTO;

import java.util.List;

public interface MyPageRepositoryQueryDsl {
  List<ReviewDTO> getMyReviews(String userId);
}
