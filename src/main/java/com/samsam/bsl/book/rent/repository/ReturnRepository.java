package com.samsam.bsl.book.rent.repository;

import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.repository.querydsl.RentRepositoryQueryDsl;
import com.samsam.bsl.book.rent.repository.querydsl.ReturnRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReturnRepository extends JpaRepository<RentHistory, Long>, ReturnRepositoryQueryDsl {
}
