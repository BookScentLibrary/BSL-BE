package com.samsam.bsl.book.rent.repository.querydsl;

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
}
