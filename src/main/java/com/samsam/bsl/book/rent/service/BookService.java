package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    // 책 정보 조회
    public Book getBook(int bookNo) {
        return bookRepository.getBook(bookNo);
    }

    // 책 별점 정보 조회
    public Rate getRate(int bookNo) {
        return bookRepository.getRate(bookNo);
    }

    // 책 대출 정보 조회
    public Reader getReader(int bookNo) {
        return bookRepository.getReader(bookNo);
    }

    // 책 관련 리뷰 조회
    public List<ReviewDTO> getReview(int bookNo) {
        return bookRepository.getReview(bookNo);
    }
}
