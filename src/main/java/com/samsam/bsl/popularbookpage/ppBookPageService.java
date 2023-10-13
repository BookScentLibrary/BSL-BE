package com.samsam.bsl.popularbookpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.samsam.bsl.book.rent.domain.Book;

@Service
public class ppBookPageService {
		
	
	@Autowired
	private static ppBookPageRepository ppbookPageRepository;
	
	public static Page<Book> findTop20ByOrderByRentCntDesc(Pageable pageable) {
	return ppbookPageRepository.findTop20ByOrderByRentCntDesc(pageable);
	                             
	}



	
	
}
