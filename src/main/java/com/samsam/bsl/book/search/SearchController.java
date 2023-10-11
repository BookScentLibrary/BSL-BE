package com.samsam.bsl.book.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.BookDTO;
import com.samsam.bsl.book.rent.domain.Book;

@RestController
@RequestMapping("/book")
public class SearchController {

	
	@Autowired
    private SearchService searchService; // BookService 클래스에 대한 의존성 주입

    @GetMapping("/search") // 책 검색을 위한 엔드포인트
    public ResponseEntity<Object> searchBooks(@RequestParam("searchValue") String searchValue,
    										@RequestParam("pageNumber") int pageNumber, 
    										@RequestParam("pageSize")int pageSize) {
       System.out.println("검색어,페이지 번호, 페이지 크기 :" +searchValue +pageNumber + pageSize);
    	Page<Book> bookDTOs = searchService.searchBookConfirm(searchValue, pageNumber, pageSize);
    	
        if (searchValue != null) {
            return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
        } else {
        	return ResponseEntity.status(HttpStatus.OK).body("검색 결과 없음");
        }
    }

}
	
	
	
	
	
	
//	int pageNumber = 1; // 원하는 페이지 번호
//	int pageSize = 10; // 원하는 페이지 크기
//	Sort sort = Sort.by("bookname").ascending(); // 정렬 기준 (예: 제목을 오름차순으로 정렬)
//
//	Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
//	
//
//		@Autowired
//	    private SearchService searchService; // BookService 클래스에 대한 의존성 주입
//		
//		
//
//	    @GetMapping("/search") // 책 검색을 위한 엔드포인트
//	    public ResponseEntity<Object> searchBooks(@RequestParam("searchValue") String searchValue, Book bookDTO) {
//	       System.out.println("검색어:" +searchValue);
//	    	Page<Book> bookDTOs = searchService.searchBookConfirm(searchValue);
//	    	                                                  //이 부분 오류 어떡하지??
//	    	
//	        if (bookDTOs != null) {
//	            return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
//	        } else {
//	        	return ResponseEntity.status(HttpStatus.OK).body("검색 결과 없음");
//	        }
//	    }
//	    
//
//
//}
