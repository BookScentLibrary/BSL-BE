package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;

public interface BookRepositoryQueryDsl {
    Book getBook(int bookNo);
    Rate getRate(int bookNo);
    Reader getReader(int bookNo);
}