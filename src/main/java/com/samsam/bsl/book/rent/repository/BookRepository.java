package com.samsam.bsl.book.rent.repository;

<<<<<<< HEAD
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.repository.querydsl.BookRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryQueryDsl {
=======
import com.samsam.bsl.book.rent.entity.BookEntity;
import com.samsam.bsl.book.rent.repository.querydsl.BookRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long>, BookRepositoryQueryDsl {

>>>>>>> bd3ce8904892fe6c7fe509cb7d5f72c4ab73240b
}
