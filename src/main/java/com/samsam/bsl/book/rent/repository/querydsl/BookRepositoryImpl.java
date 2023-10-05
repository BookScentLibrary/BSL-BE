package com.samsam.bsl.book.rent.repository.querydsl;

<<<<<<< HEAD
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;

import javax.persistence.EntityManager;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.rent.domain.QRate.rate;
import static com.samsam.bsl.book.rent.domain.QReader.reader;

public class BookRepositoryImpl implements BookRepositoryQueryDsl {
    private final JPAQueryFactory queryFactory;

    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Book getBook(int bookNo) {
        Book result;
        return result = queryFactory
                .select(Projections.constructor(
                        Book.class,
                        book.bookNo,
                        book.bookname,
                        book.author,
                        book.publisher,
                        book.publicationYear,
                        book.callNum,
                        book.shelfArea,
                        book.format,
                        book.className,
                        book.bookStatus,
                        book.rentCnt,
                        book.isbn,
                        book.description
                ))
                .from(book)
                .where(book.bookNo.eq(bookNo))
                .fetchOne();
    }

    @Override
    public Rate getRate(int bookNo) {
        Rate result;
        return result = queryFactory
                .select(Projections.constructor(
                        Rate.class,
                        rate.bookNo,
                        rate.point_1,
                        rate.point_2,
                        rate.point_3,
                        rate.point_4,
                        rate.point_5
                ))
                .from(rate)
                .where(rate.bookNo.eq(bookNo))
                .fetchOne();
    }

    @Override
    public Reader getReader(int bookNo) {
        Reader result;
        return result = queryFactory
                .select(Projections.constructor(
                        Reader.class,
                        reader.bookNo,
                        reader.m_10,
                        reader.f_10,
                        reader.m_20,
                        reader.f_20,
                        reader.m_30,
                        reader.f_30,
                        reader.m_40,
                        reader.f_40,
                        reader.m_50,
                        reader.f_50,
                        reader.m_senior,
                        reader.f_senior
                ))
                .from(reader)
                .where(reader.bookNo.eq(bookNo))
                .fetchOne();
    }
=======
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.dto.BookDTO;
import org.hibernate.criterion.Projection;

import javax.persistence.EntityManager;

import static com.samsam.bsl.book.rent.entity.QBookEntity.bookEntity;

public class BookRepositoryImpl implements BookRepositoryQueryDsl {

  private final JPAQueryFactory queryFactory;

  public BookRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public BookDTO getBook(int bookNo) {
    BookDTO book;
    return book = queryFactory
                  .select(Projection.constructor
                    (BookDTO.class,
                      bookEntity.bookNo,
                      bookEntity.bookname,
                      bookEntity.bookImageURL,
                      bookEntity.author,
                      bookEntity.publisher,
                      bookEntity.publicationYear,
                      bookEntity.format,
                      bookEntity.shelfarea,
                      bookEntity.callNum,
                      bookEntity.className,
                      bookEntity.bookStatus,
                      bookEntity.rentCnt,
                      bookEntity.isbn,
                      bookEntity.description
                      ))
      .from(bookEntity)
      .where(bookEntity.bookNo.eq(bookNo))
      .fetchOne();
  }
>>>>>>> bd3ce8904892fe6c7fe509cb7d5f72c4ab73240b
}
