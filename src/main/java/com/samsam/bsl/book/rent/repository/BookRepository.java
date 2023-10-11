package com.samsam.bsl.book.rent.repository;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.repository.querydsl.BookRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryQueryDsl {
}

