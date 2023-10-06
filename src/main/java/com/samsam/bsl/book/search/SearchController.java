package com.samsam.bsl.book.search;

import java.util.List;

import com.samsam.bsl.book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
public class SearchController {
	
	
//	 @Autowired
//	    private SearchService searchService;
//
//	    @GetMapping("/book/search")
//	    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam("bookName") String bookName) {
//	        List<BookDTO> bookDTOs = searchService.searchBookConfirm(bookName);
//	        if (bookDTOs != null && !bookDTOs.isEmpty()) {
//	            return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//	        }
//	    }
	
	
	
	
	
	
	
	
//	@GetMapping("/search")  // 리액트에서 보낼 때, 검색어를 url에 담아서 보냄 여기서 리퀘스트 파람써서 보내면 됨. 
	   
	
		@Autowired
	    private SearchService searchService; // BookService 클래스에 대한 의존성 주입

	    @GetMapping("/book/search") // 책 검색을 위한 엔드포인트
	    public ResponseEntity<List<BookDTO>> searchBooks(BookDTO bookDTO) {
	        List<BookDTO> bookDTOs = searchService.searchBookConfirm(bookDTO);
	        if (bookDTOs != null) {
	            return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

}
