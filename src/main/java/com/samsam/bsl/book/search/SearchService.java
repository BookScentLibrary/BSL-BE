package com.samsam.bsl.book.search;


import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.search.repository.SearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SearchService {
	
	
	@Autowired
	SearchRepository searchRepository; 
	
	
	
	public Page<Book> searchBookConfirm(String searchValue, int searchType, int pageNumber, int pageSize ) {
 	   // = PageRequest.of(pageNumber-1, pageSize);
 	   Sort sort = Sort.by(Sort.Order.asc("bookname"));
 	   Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
 	   System.out.println("service "+ pageable);
 	   if(searchValue == null) {
 		   return null;
 				   //searchRepository.ErrorPage(pageable);	
 		  //검색 결과가 없다는 페이지를 만들어야 함. 
 	   } else if ( searchType == 1 ) {
 		   return searchRepository.findBybooknameContaining(searchValue, pageable);
 	   }else if (searchType == 2) {
 		   return searchRepository.findByAuthorContaining(searchValue, pageable);
 	   }else if(searchType == 3){ 
 		   return searchRepository.findByPublisherContaining(searchValue, pageable);
// 	   }else if (searchType == 0) {
// 		   return searchRepository.keywordAll(searchValue, pageable);
// 	   }
 	   }else {
 	   	return searchRepository.findBybooknameContaining(searchValue, pageable);
 	   			//searchRepository.keywordAll(searchValue, pageable);

 	   }
 	   
		
    }
	
	
}
	        
	        
	        
	    
	
	

