package com.samsam.bsl.book.search.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.samsam.bsl.book.rent.domain.Book;

public interface SearchRepositoryQueryDsl {
	Book getBookname (String bookname);
	Book getAuthor (String author);
	Book getPublisher (String publisher);
	Page<Book> findBybooknameContaining(String searchValue,Pageable pageable);


}
