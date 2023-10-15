package com.samsam.bsl.book.rent.repository.querydsl;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rate;
import com.samsam.bsl.book.rent.domain.Reader;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.user.entity.UserEntity;

import java.util.List;

public interface BookRepositoryQueryDsl {
    Book getBook(int bookNo);
    Rate getRate(int bookNo);
    Reader getReader(int bookNo);
    List<ReviewDTO> getReview(int bookNo);
}
