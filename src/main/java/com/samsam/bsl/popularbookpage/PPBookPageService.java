package com.samsam.bsl.popularbookpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.samsam.bsl.book.rent.domain.Book;

@Service
public class PPBookPageService {

	@Autowired
	private static PPBookPageRepository ppbookPageRepository;
	
	public static Page<Book> findTop10ByOrderByRentCntDesc(Pageable pageable) {
	return ppbookPageRepository.findTop10ByOrderByRentCntDesc(pageable);
	                             
	}


	
	
}
