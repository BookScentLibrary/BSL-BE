package com.samsam.bsl.newbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewBookRepository extends JpaRepository<NewBook, Long> {	
	@Query(value = "SELECT * FROM newbook ORDER BY regDate", nativeQuery = true)
	List<NewBook> newBooksRanking();
}
