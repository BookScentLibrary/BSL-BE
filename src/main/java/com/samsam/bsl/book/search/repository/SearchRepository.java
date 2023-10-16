package com.samsam.bsl.book.search.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.book.rent.domain.Book;


@Repository
public interface SearchRepository extends JpaRepository<Book, Integer>{
	
//	Page<Book> findAllbooknameContainingOrAuthorContainingOrPublisherContaining(String searchValue, Pageable pageable);

	Page<Book>findBybooknameContaining(String searchValue,Pageable pageable);

	Page<Book> findByAuthorContaining(String searchValue, Pageable pageable);

	Page<Book> findByPublisherContaining(String searchValue, Pageable pageable);

	//Page<Book> ErrorPage(Pageable pageable);
}

	
