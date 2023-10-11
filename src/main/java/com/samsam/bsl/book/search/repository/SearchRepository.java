package com.samsam.bsl.book.search.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.book.rent.domain.Book;


@Repository
public interface SearchRepository extends JpaRepository<Book, Integer>{
	
//	@Query(value="SELECT * FROM books WHERE bookname LIKE ? AND ORDER BY bookNo DESC");
	Page<Book>findBybooknameContaining(String searchValue,Pageable pageable);
//	Page<Book>findByauthorContaining(String authorValue );
//	//아서밸류랑 퍼블리셔밸류는 만들어야 함. 아직 없음 
//	Page<Book>findBypublisherContaining(String publisherValue);
//	
//	Page<Book> searchResult = searchRepository.findBybooknameContaining("searchValue");
//	
//	
//	if (bookOptional.isPresent()) {
//	    Book book = bookOptional.get();
//	    // 값이 존재하는 경우 책 정보를 처리
//	} else {
//	    // 값이 없는 경우 처리
//	}
//}
}
	
