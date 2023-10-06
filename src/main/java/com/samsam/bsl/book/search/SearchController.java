package com.samsam.bsl.book.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	    public ResponseEntity<Object> searchBooks(@RequestParam("searchValue") String searchValue, Book bookDTO) {
	       System.out.println("검색어:" +searchValue);
	    	List<Book> bookDTOs = searchService.searchBookConfirm(searchValue);
	    	
	        if (bookDTOs != null) {
	            return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
	        } else {
	        	return ResponseEntity.status(HttpStatus.OK).body("검색 결과 없음");
	        }
	    }

}
