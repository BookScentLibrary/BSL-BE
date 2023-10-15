package com.samsam.bsl.book.rent.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.RentHistory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.rent.domain.QRentHistory.rentHistory;


public class ReturnRepositoryImpl implements ReturnRepositoryQueryDsl{

  private final JPAQueryFactory queryFactory;

  static final int SUCCESS = 1;
  static final int FAIL = 0;

  public ReturnRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  @Transactional
  public int updateReturnedDate(String userId, int bookNo, LocalDateTime returnedDate) {

    Long result = queryFactory
      .update(rentHistory)
      .set(rentHistory.returnedDate, returnedDate)
      .where(rentHistory.userId.eq(userId), rentHistory.bookNo.eq(bookNo), rentHistory.returnedDate.isNull())
      .execute();

    if(result == 0) {
      return FAIL;
    } else {
      return SUCCESS;
    }
  }

  @Override
  public List<RentHistory> getRentHistory(String userId) {
    List<RentHistory> list = queryFactory
      .selectFrom(rentHistory)
      .where(rentHistory.userId.eq(userId))
      .fetch();
    return list;
  }
}
