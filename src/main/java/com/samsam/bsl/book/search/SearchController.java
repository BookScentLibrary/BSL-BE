package com.samsam.bsl.book.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.rent.domain.Book;

@RestController
@RequestMapping("/book")
public class SearchController {

  @Autowired
  private SearchService searchService; 

  @GetMapping("/search") 
  public ResponseEntity<Object> searchBooks(

    @RequestParam("searchValue") String searchValue,
    @RequestParam("searchType") int searchType,
    @RequestParam("pageNumber") int pageNumber,
    @RequestParam("pageSize") int pageSize) {

    Page<Book> bookDTOs = searchService.searchBookConfirm(searchType, searchValue, pageNumber, pageSize);

    if (searchValue != null) {
      return ResponseEntity.status(HttpStatus.OK).body(bookDTOs);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body("검색 결과 없음");
    }
  }


}
