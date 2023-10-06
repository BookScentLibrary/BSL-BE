package com.samsam.bsl.book.search;

import java.util.List;

import com.samsam.bsl.book.rent.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchService {
	

	        @Autowired
	        private SearchDAO searchDAO;

	        public List<BookDTO> searchBookConfirm(String searchValue) {
	        	System.out.println("[Service]searchValue :" + searchValue);
	            List<BookDTO> bookDTOs = searchDAO.selectBooksBySearch(searchValue);
	            return bookDTOs;
	        }
	    }
	
	

