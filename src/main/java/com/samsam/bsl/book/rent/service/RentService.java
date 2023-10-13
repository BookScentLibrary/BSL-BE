package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RentService {
    static final int FAIL = 0;
    static final int SUCCESS = 1;
    static final int FULL_RENT = 2;
    static final int ALEADY_RENTED_BOOK = 3;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    @Autowired
    BookRepository bookRepository;

    public int rent(String username, int bookNo) {
        int status = bookRepository.getBook(bookNo).getBookStatus();
        if(status!=0) {
            return ALEADY_RENTED_BOOK;
        }

        boolean user = userRepository.existsByUsername(username);
        int bookCnt = rentRepository.RentedBookCnt(username);

        if (user && bookCnt < 3) {
            LocalDateTime rentDate = LocalDateTime.now();
            LocalDateTime expireDate = rentDate.plusDays(7).with(LocalTime.MIDNIGHT);
            Rent rent = new Rent(username, bookNo, rentDate.toString(), expireDate.toString());
            int updateResult = rentRepository.updateBookStatus(username, bookNo);
            if(updateResult == SUCCESS) {

            }
            rentRepository.save(rent);
            return SUCCESS;
        } else if (bookCnt >= 3) {
            return FULL_RENT;
        } else {
            return FAIL;
        }
    }
    public List<RentedBook> getUsersRentBookList(String username) {
        return rentRepository.getUsersRentBook(username);
    }

    public int returnBook(String username, int bookNo) {
        return rentRepository.returnBook(username, bookNo);
    }
}
