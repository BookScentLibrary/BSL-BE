package com.samsam.bsl.book.rent.repository.querydsl;

<<<<<<< HEAD
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;

public interface BookRepositoryQueryDsl {
    Book getBook(int bookNo);
    Rate getRate(int bookNo);
    Reader getReader(int bookNo);
=======

import com.samsam.bsl.book.rent.entity.BookEntity;

public interface BookRepositoryQueryDsl {
  BookEntity getBook(int bookNo);
>>>>>>> bd3ce8904892fe6c7fe509cb7d5f72c4ab73240b
}
