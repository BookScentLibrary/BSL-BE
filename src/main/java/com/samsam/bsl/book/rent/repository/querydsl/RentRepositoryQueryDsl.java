package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.dto.RentedBook;

import java.util.List;

public interface RentRepositoryQueryDsl {
    List<RentedBook> getUsersRentBook(String userId);
    int RentedBookCnt(String userId);
    int updateBookStatus(String userId, int bookNo);
    int returnBook(String userId, int bookNo);
}
