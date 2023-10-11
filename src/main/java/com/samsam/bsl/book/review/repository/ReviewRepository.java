package com.samsam.bsl.book.review.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.book.review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("SELECT r FROM Review r LEFT JOIN FETCH r.user u LEFT JOIN FETCH r.book b WHERE u.userId = r.userId AND b.bookNo = r.bookNo")
	//@Query("SELECT r, u.nickname, b.bookname, b.author, b.publisher, b.callNum, b.shelfArea FROM Review r JOIN r.user u JOIN r.book b")
	List<Review> getAllReviews();

	List<Review> findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
			String bookname, String postTitle, String author, String publisher, String callNum, String publicationYear);

	List<Review> findByBook_booknameContaining(String bookname);

	List<Review> findByPostTitleContaining(String postTitle);  

	List<Review> findByBook_authorContaining(String author);

	List<Review> findByBook_publisherContaining(String publisher);

	List<Review> findByBook_callNumContaining(String callNum);

	List<Review> findByBook_publicationYearContaining(String publicationYear);
	
//	@Query("SELECT r FROM Review r LEFT JOIN FETCH r.user u LEFT JOIN FETCH r.book b WHERE u.userId = r.userId AND b.bookNo = r.bookNo")
//	Page<Review> getAllReviews(@Param("userId") Long userId, @Param("bookNo") Long bookNo, Pageable pageable);
//
//	Page<Review> findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
//	    String bookname, String postTitle, String author, String publisher, String callNum, String publicationYear, Pageable pageable);
//
//	Page<Review> findByBook_booknameContaining(String bookname, Pageable pageable);
//
//	Page<Review> findByPostTitleContaining(String postTitle, Pageable pageable);
//
//	Page<Review> findByBook_authorContaining(String author, Pageable pageable);
//
//	Page<Review> findByBook_publisherContaining(String publisher, Pageable pageable);
//
//	Page<Review> findByBook_callNumContaining(String callNum, Pageable pageable);
//
//	Page<Review> findByBook_publicationYearContaining(String publicationYear, Pageable pageable);

}