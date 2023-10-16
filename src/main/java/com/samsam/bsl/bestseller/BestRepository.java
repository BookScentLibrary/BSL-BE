package com.samsam.bsl.bestseller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.book.rent.domain.Book;

public interface BestRepository extends JpaRepository<Best, Long> {
  List<Best> findAllByOrderByRankAsc();
}
