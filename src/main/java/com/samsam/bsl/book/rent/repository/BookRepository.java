package com.samsam.bsl.book.rent.repository;

import com.samsam.bsl.book.rent.entity.BookEntity;
import com.samsam.bsl.book.rent.repository.querydsl.BookRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long>, BookRepositoryQueryDsl {

}
