package com.samsam.bsl.newbook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewBookRepository extends JpaRepository<NewBook, Long>, NewBookRepositoryQueryDsl {
}