package com.samsam.bsl.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query("SELECT r FROM Review r LEFT JOIN FETCH r.user LEFT JOIN FETCH r.book")
	List<Review> getAllReviews();
}