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
    public List<Review> getMyReviews(String userId) {
        List<Review> reviews = queryFactory
                .selectFrom(review)
                .where(review.userId.eq(userId))
                .orderBy(review.createdAt.desc())
                .fetch();

        return reviews;
    }

    public List<Review> getMyReviewMain(String userId) {
        List<Review> reviews = queryFactory
                .selectFrom(review)
                .where(review.userId.eq(userId))
                .orderBy(review.createdAt.desc())
                .limit(6)
                .fetch();

        return reviews;
    }
}
