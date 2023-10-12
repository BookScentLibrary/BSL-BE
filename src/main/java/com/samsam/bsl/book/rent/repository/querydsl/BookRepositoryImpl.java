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
				.select(Projections.constructor(Book.class, book.bookNo, book.bookImageURL, book.bookname, book.author,
						book.publisher, book.publicationYear, book.callNum, book.shelfArea, book.format, book.className,
						book.bookStatus, book.rentCnt, book.isbn, book.description, book.regDate))
				.from(book).where(book.bookNo.eq(bookNo)).fetchOne();
	}

	@Override
	public Rate getRate(int bookNo) {
		Rate result;
		return result = queryFactory.select(Projections.constructor(Rate.class, rate.bookNo, book, rate.point_1,
				rate.point_2, rate.point_3, rate.point_4, rate.point_5)).from(rate).where(rate.bookNo.eq(bookNo))
				.fetchOne();
	}

	@Override
	public Reader getReader(int bookNo) {
		Reader result;
		return result = queryFactory
				.select(Projections.constructor(Reader.class, reader.bookNo, book, reader.m_10, reader.f_10,
						reader.m_20, reader.f_20, reader.m_30, reader.f_30, reader.m_40, reader.f_40, reader.m_50,
						reader.f_50, reader.m_senior, reader.f_senior))
				.from(reader).where(reader.bookNo.eq(bookNo)).fetchOne();
	}

	@Override
	public UserEntity getUserInfo(String username) {
		UserEntity result;
		return result = queryFactory
				.select(Projections.constructor(UserEntity.class, userEntity.userId, userEntity.username,
						userEntity.password, userEntity.email, userEntity.nickname, userEntity.phone, userEntity.gender,
						userEntity.userBirth, userEntity.userAge, userEntity.permission))
				.from(userEntity).where(userEntity.username.eq(username)).fetchOne();
	}
}
