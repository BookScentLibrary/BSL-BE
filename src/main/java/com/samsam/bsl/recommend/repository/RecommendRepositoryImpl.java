package com.samsam.bsl.recommend.repository;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.user.repository.UserRepository;

public class RecommendRepositoryImpl implements RecommendRepositoryQueryDsl {
    private final JPAQueryFactory queryFactory;
    private final BookRepository bookRepository; // BookRepository 의존성 주입
    private final UserRepository userRepository; // UserRepository 의존성 주입

    public RecommendRepositoryImpl(EntityManager em, BookRepository bookRepository, UserRepository userRepository) {
        this.queryFactory = new JPAQueryFactory(em);
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }
    
    

}
