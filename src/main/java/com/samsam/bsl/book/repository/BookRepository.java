package com.samsam.bsl.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}