package com.samsam.bsl.book.rent.repository;

import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.repository.querydsl.RentRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long>, RentRepositoryQueryDsl {
}
