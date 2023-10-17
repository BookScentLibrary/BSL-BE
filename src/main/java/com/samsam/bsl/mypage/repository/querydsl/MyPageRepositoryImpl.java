package com.samsam.bsl.mypage.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.review.domain.Review;
import com.querydsl.core.types.Projections;
import com.samsam.bsl.mypage.dto.ReviewDTO;

import javax.persistence.EntityManager;
import java.util.List;

import static com.samsam.bsl.book.review.domain.QReview.review;

public class MyPageRepositoryImpl implements MyPageRepositoryQueryDsl {

  private final JPAQueryFactory queryFactory;

  public MyPageRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<ReviewDTO> getMyReviews(String userId) {
    List<ReviewDTO> reviews = queryFactory
      .select(Projections.constructor(
        ReviewDTO.class,
        review.rev_postId,
        review.postTitle,
        review.bookNo,
        review.createdAt))
      .from(review)
      .where(review.userId.eq(userId))
      .fetch();

    return reviews;
  }
}
