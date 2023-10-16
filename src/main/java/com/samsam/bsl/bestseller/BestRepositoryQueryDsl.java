package com.samsam.bsl.bestseller;

import java.util.List;

import com.samsam.bsl.book.rent.domain.Book;

public interface BestRepositoryQueryDsl {

	List<Book> getBestseller();
	
//	List<Best> findAll();
}
