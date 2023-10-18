package com.samsam.bsl.mypage.repository;

import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.mypage.repository.querydsl.MyPageRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyPageRepository extends JpaRepository<Review, Long>, MyPageRepositoryQueryDsl {
    List<Review> findAllByUserIdOrderByCreatedAtDesc(String userId);
}
