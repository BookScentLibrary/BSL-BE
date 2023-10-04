package com.samsam.bsl.book.rent.repository.querydsl;


import com.samsam.bsl.book.rent.entity.BookEntity;

public interface BookRepositoryQueryDsl {
  BookEntity getBook(int bookNo);
}
