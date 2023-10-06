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

	List<Review> findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
			String bookname, String postTitle, String author, String publisher, String callNum, String publicationYear);

	List<Review> findByBook_booknameContaining(String bookname);

	List<Review> findByPostTitleContaining(String postTitle);

	List<Review> findByBook_authorContaining(String author);

	List<Review> findByBook_publisherContaining(String publisher);

	List<Review> findByBook_callNumContaining(String callNum);

	List<Review> findByBook_publicationYearContaining(String publicationYear);
}