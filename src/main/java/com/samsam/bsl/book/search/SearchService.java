package com.samsam.bsl.book.search;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.dto.BookDTO;
import com.samsam.bsl.book.search.repository.SearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SearchService {
	
	
	@Autowired
	SearchRepository searchRepository; 
	
	
//	int pageNumber = 1; // 원하는 페이지 번호
//	int pageSize = 10; // 원하는 페이지 크기
//	Sort sort = Sort.by("bookname").ascending(); // 정렬 기준 (예: 제목을 오름차순으로 정렬)

//	Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
//	PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);


	


	PageRequest pageRequest;
	
       public Page<Book> searchBookConfirm(String searchValue, int pageNumber, int pageSize ) {
    	   // = PageRequest.of(pageNumber-1, pageSize);
    	   Sort sort = Sort.by(Sort.Order.asc("bookname"));
    	   Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
    	   System.out.println("service "+ pageable);
    	   return searchRepository.findBybooknameContaining(searchValue, pageable);
       }
}
       
       
//    	Page<Book> resultPage = searchRepository.findBybooknameContaining(searchValue, pageable);
//       	System.out.println("[Service]searchValue :" + searchValue);
//           Page<Book> bookDTOs = searchDAO.selectBooksBySearch(searchValue);
//           return bookDTOs;
//       }
//   	
//   	Page<Book> resultPage = SearchRepository.findAll(pageable);
//   	
//   	
//       
//       
//       if (pageNumber >= 0 && pageNumber < bookList.size() && pageSize > pageNumber) {
//           bookDTOs = new PageImpl<>(bookList.subList(pageNumber, pageSize), pageRequest, bookList.size());
//       } else {
//           bookDTOs = new PageImpl<>(Collections.emptyList(), pageRequest, 0);
//       }
//       
//       
//   	int start = (int) pageRequest.getOffset();
//   	int end = Math.min((start + pageRequest.getPageSize()),bookList.size());
//       
//       bookDTOs = new PageImpl<>(bookList.subList(start,end), pageRequest, bookList.size()); // start, end, PageRequest객체
//       return bookDTOs.getSize() > 0 ? bookDTOs : null;
//   }
   
	
	
//	@Autowired
//	 private Book book;
//	
//	public Page<Book> searchBookConfirm(String searchValue,Pageable pageable){
//		 return SearchRepositoryImp.findBybooknameContaining(searchValue,pageable);
//	}

//
//	        @Autowired
//	        private SearchDAO searchDAO;
//
//	        public List<Book> searchBookConfirm(String searchValue) {
//	        	System.out.println("[Service]searchValue :" + searchValue);
//	            List<Book> bookDTOs = searchDAO.selectBooksBySearch(searchValue);
//	            return bookDTOs;
//	        }
//	     
//	        public Page<Book> SearchList(String searchValue, Pageable pageable){
//				
//	        	
//	        	return SearchRepositoryImp.findBybooknameContaining(searchValue, pageable);
//	        	
//	        }
	       
	        
	        
	        
	    
	
	

