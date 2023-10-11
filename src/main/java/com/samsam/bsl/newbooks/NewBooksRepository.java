package com.samsam.bsl.newbooks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewBooksRepository extends JpaRepository<NewBooksDTO, Long> {
    @Query(value = "SELECT * FROM books ORDER BY regDate DESC LIMIT 20", nativeQuery = true)
	List<NewBooksDTO> newBooksRanking();
}