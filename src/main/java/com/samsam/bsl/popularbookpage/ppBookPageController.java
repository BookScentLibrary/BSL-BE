
package com.samsam.bsl.popularbookpage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.rent.domain.Book;

@RestController
@RequestMapping("/book")
public class ppBookPageController {


	@Autowired
    private ppBookPageService ppbookService;
	
	@GetMapping("/ppBooks")
	public List<Book> getppBook(){
		List<Book> getppBook = ppbookService.findByOrderByRentCntDesc();
		
		return getppBook;
	}
	}



	

//@ResponseBody
// public ResponseEntity<Object> findByrentCntOrderByRentCntDesc(
//		@RequestParam("rentCnt") String searchValue
//		){
//	return bookService.findByrentCntOrderByRentCntDesc(rentCnt);
//	System.out.println("오류 발생");



//package com.samsam.bsl.popularbookpage;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.samsam.bsl.book.rent.domain.Book;
//
//@RestController
//@RequestMapping("/book")
//public class ppBookPageController {
//
//
//	@Autowired
//    private ppBookPageService ppbookService;
//
//	@GetMapping("/ppBooks")
//	public List<Book> getppBook(){
//		List<Book> getppBook = ppbookService.findByrentCntOrderByRentCntDesc();
//
//		return getppBook;
//
//	}
//
//}
//
//
////@ResponseBody
//// public ResponseEntity<Object> findByrentCntOrderByRentCntDesc(
////		@RequestParam("rentCnt") String searchValue
////		){
////	return bookService.findByrentCntOrderByRentCntDesc(rentCnt);
////	System.out.println("오류 발생");
//

