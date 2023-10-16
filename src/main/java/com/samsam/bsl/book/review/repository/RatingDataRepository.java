package com.samsam.bsl.book.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.book.review.domain.RatingData;


public interface RatingDataRepository extends JpaRepository<RatingData, Integer>{
	RatingData findByBookNo(int bookNo);
}
