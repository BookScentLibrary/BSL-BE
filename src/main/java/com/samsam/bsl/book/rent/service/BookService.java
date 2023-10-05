package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book getBook(int bookNo) {
        return bookRepository.getBook(bookNo);
    }

    public Rate getRate(int bookNo) {
        return bookRepository.getRate(bookNo);
    }

    public Reader getReader(int bookNo) {
        return bookRepository.getReader(bookNo);
    }
}
