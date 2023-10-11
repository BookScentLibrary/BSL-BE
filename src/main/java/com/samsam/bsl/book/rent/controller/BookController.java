package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/")
    public @ResponseBody Book testApi() {
        System.out.println("test api 동작");
        return bookService.getBook(1);
    }
}