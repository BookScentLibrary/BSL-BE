package com.samsam.bsl.popularbookpage;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.book.rent.domain.Book;

@Repository
public interface ppBookPageRepository extends JpaRepository<Book, Integer>{
	List<Book> findByrentCntOrderByRentCntDesc();
}
