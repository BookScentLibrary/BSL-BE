package com.samsam.bsl.book.rent.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.user.entity.UserEntity;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.rent.domain.QRate.rate;
import static com.samsam.bsl.book.rent.domain.QReader.reader;
import static com.samsam.bsl.book.review.domain.QReview.review;

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
  public List<ReviewDTO> getReview(int bookNo) {
    List<Review> result = queryFactory
      .selectFrom(review)
      .where(review.bookNo.eq(bookNo))
      .orderBy(review.createdAt.desc())
      .limit(5)
      .fetch();
    List<ReviewDTO> reviews = new ArrayList<ReviewDTO>();
    for (int i = 0; i < result.size(); i++) {
      Review r = result.get(i);
      Book b = r.getBook();
      System.out.println(b);
      ReviewDTO rev = new ReviewDTO();

      rev.setBookImageURL(b.getBookImageURL());
      rev.setBookNo(b.getBookNo());
      rev.setAuthor(b.getAuthor());
      rev.setBookname(b.getBookname());
      rev.setIsbn(b.getIsbn());
      rev.setModifiedAt(r.getModifiedAt());
      rev.setNickname(r.getUser().getNickname());
      rev.setPostTitle(r.getPostTitle());
      rev.setPublisher(b.getPublisher());
      rev.setCallNum(b.getCallNum());
      rev.setRev_postId(r.getRev_postId());
      rev.setUserId(r.getUserId());
      rev.setContent(r.getContent());
      rev.setShelfArea(b.getShelfArea());
      rev.setCreatedAt(r.getCreatedAt());
      rev.setRate(r.getRate());
      reviews.add(rev);
    }

    return reviews;
  }
}
