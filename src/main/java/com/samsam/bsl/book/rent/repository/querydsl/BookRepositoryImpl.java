package com.samsam.bsl.book.rent.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.user.entity.UserEntity;

import javax.persistence.EntityManager;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.rent.domain.QRate.rate;
import static com.samsam.bsl.book.rent.domain.QReader.reader;
import static com.samsam.bsl.user.entity.QUserEntity.userEntity;

public class BookRepositoryImpl implements BookRepositoryQueryDsl {
  private final JPAQueryFactory queryFactory;

  public BookRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public Book getBook(int bookNo) {
    Book result;
    return result = queryFactory
      .selectFrom(book)
      .where(book.bookNo.eq(bookNo))
      .fetchOne();
  }

  @Override
  public Rate getRate(int bookNo) {
    Rate result;
    return result = queryFactory
      .selectFrom(rate)
      .where(rate.bookNo.eq(bookNo))
      .fetchOne();
  }

  @Override
  public Reader getReader(int bookNo) {
    Reader result;
    return result = queryFactory
      .selectFrom(reader)
      .where(reader.bookNo.eq(bookNo))
      .fetchOne();
  }

  @Override
  public UserEntity getUserInfo(String username) {
    UserEntity result;
    return result = queryFactory
      .selectFrom(userEntity)
      .where(userEntity.username.eq(username))
      .fetchOne();
  }
}
