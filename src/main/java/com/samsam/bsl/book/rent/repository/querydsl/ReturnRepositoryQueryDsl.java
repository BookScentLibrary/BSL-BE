package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.domain.RentHistory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReturnRepositoryQueryDsl {
  int updateReturnedDate(String userId, int bookNo, LocalDateTime returnedDate);

  List<RentHistory> getRentHistory(String userId);
}
