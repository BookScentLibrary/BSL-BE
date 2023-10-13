package com.samsam.bsl.newbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewBookRepository extends JpaRepository<NewBook, Long> {	
	@Query(value = "SELECT b.bookname, b.author, b.publisher, b.publicationYear, b.regDate FROM books b INNER JOIN newBook n ON b.bookNo = n.bookNo;", nativeQuery = true)
	List<NewBook> newBookRanking();
}