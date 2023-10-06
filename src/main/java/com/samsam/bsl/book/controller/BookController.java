package com.samsam.bsl.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
    private BookService bookService;
    
}