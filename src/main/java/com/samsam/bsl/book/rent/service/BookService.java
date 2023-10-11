package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    public Book getBook(int bookNo) {
        return bookRepository.getBook(bookNo);
    }

    public Rate getRate(int bookNo) {
        return bookRepository.getRate(bookNo);
    }

    public Reader getReader(int bookNo) {
        return bookRepository.getReader(bookNo);
    }

    public int rent(String username, int bookNo) {
//        UserEntity user = bookRepository.getUserInfo(username);
//        Book book = bookRepository.getBook(bookNo);
        LocalDateTime rentDate = LocalDateTime.now();
        LocalDateTime expireDate = rentDate.plusDays(7).with(LocalTime.MIDNIGHT);
        Rent rent = new Rent(username, bookNo, rentDate.toString(), expireDate.toString());
        rentRepository.save(rent);
        return 0;
    }
}
