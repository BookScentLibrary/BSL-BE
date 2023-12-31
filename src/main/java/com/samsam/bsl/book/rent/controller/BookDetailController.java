package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.book.rent.service.BookService;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/detail")
public class BookDetailController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public @ResponseBody Book getBook(@RequestParam("bookNo") int bookNo) {
        Book book = new Book();
        book = bookService.getBook(bookNo);
        return book;
    }

    @GetMapping("/rate")
    public @ResponseBody Rate getRate(@RequestParam int bookNo) {
        Rate rate = new Rate();
        rate = bookService.getRate(bookNo);
        return rate;
    }

    @GetMapping("/reader")
    public @ResponseBody Reader getReader(@RequestParam int bookNo) {
        Reader reader = new Reader();
        reader = bookService.getReader(bookNo);
        return reader;
    }

    @GetMapping("/review")
    public @ResponseBody List<ReviewDTO> getReview(@RequestParam int bookNo) {
        List<ReviewDTO> reviews = bookService.getReview(bookNo);
        return reviews;
    }

}

