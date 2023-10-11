package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.user.entity.UserEntity;

public interface BookRepositoryQueryDsl {
    Book getBook(int bookNo);
    Rate getRate(int bookNo);
    Reader getReader(int bookNo);
    UserEntity getUserInfo(String username);
}
