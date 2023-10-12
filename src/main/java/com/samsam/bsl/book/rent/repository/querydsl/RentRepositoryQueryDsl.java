package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.dto.RentedBook;

import java.util.List;

public interface RentRepositoryQueryDsl {
    List<RentedBook> getUsersRentBook(String username);
    int RentedBookCnt(String username);
    int updateBookStatus(String username, int bookNo);
    int returnBook(String username, int bookNo);
}
