package com.samsam.bsl.popularbookpage;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.samsam.bsl.book.rent.domain.Book;

public interface ppBookPageRepositoryQueryDsl {

	List<Book> findByrentCntOrderByRentCntDesc();
}
