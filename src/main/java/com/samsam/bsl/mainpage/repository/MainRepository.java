package com.samsam.bsl.mainpage.repository;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.mainpage.repository.querydsl.MainRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<Book, Long>, MainRepositoryQueryDsl {
}
