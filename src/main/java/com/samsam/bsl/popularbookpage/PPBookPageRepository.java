package com.samsam.bsl.popularbookpage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.book.rent.domain.Book;

public interface PPBookPageRepository extends JpaRepository<Book, Integer> {

	Page<Book> findTop10ByOrderByRentCntDesc(Pageable pageable);
	
	
}
