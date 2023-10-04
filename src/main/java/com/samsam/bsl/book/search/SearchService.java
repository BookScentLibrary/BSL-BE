package com.samsam.bsl.book.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.BookDTO;

@Service
public class SearchService {
	
	
//	 @Autowired
//	    private SearchDAO searchDAO;
//
//	    public List<BookDTO> searchBookConfirm(String bookName) {
//	        List<BookDTO> bookDTOs = searchDAO.selectBooksBySearch(bookName);
//	        return bookDTOs;
//	    }

	    

	        @Autowired
	        private SearchDAO searchDAO;

	        public List<BookDTO> searchBookConfirm(BookDTO bookDTO) {
	            List<BookDTO> bookDTOs = searchDAO.selectBooksBySearch(bookDTO);
	            return bookDTOs;
	        }
	    }
	
	

