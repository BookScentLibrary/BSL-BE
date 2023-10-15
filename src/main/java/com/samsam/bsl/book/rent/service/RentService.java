package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.book.rent.repository.ReturnRepository;
import com.samsam.bsl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {
  static final int FAIL = 0;
  static final int SUCCESS = 1;
  static final int FULL_RENT = 2;
  static final int ALEADY_RENTED_BOOK = 3;
  static final int NOT_FOUND_USER = 4;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RentRepository rentRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  ReturnRepository returnRepository;

  // 도서 대출
  public int rent(String userId, int bookNo) {
    // 도서 대출 상태값 조회
    int status = bookRepository.getBook(bookNo).getBookStatus();
    if (status != 0) {
      return ALEADY_RENTED_BOOK;
    }

    // 사용자 유무 확인
    Optional user = userRepository.findById(userId);

    // 현재 사용자가 대출중인 도서 권수 확인
    int bookCnt = rentRepository.RentedBookCnt(userId);

    // 대출 시작 - 사용자가 존재하며, 대출 권수가 3권 미만
    if (user.isPresent() && bookCnt < 3) {
      LocalDateTime rentDate = LocalDateTime.now();
      LocalDateTime expireDate = rentDate.plusDays(7).with(LocalTime.MIDNIGHT);
      Rent rent = new Rent(userId, bookNo, rentDate.toString(), expireDate.toString());
      // 도서 대출 상태값 변경
      int updateResult = rentRepository.updateBookStatus(userId, bookNo);

      if (updateResult == SUCCESS) {
        try {
          // 대출 테이블에 추가
          rentRepository.save(rent);
          // 사용자 대출 내역 추가(반납일자 null)
          RentHistory history = new RentHistory(userId, bookNo, rentDate, null);
          returnRepository.save(history);
          return SUCCESS;
        } catch (Exception e) {
          return FAIL;
        }
      } else if (bookCnt >= 3) {
        return FULL_RENT;
      } else if (user.isEmpty()) {
        return NOT_FOUND_USER;
      } else {
        return FAIL;
      }
    }
    return FAIL;
  }

  // 사용자 대출중인 도서 조회
  public List<RentedBook> getUsersRentBookList(String userId) {
    return rentRepository.getUsersRentBook(userId);
  }

  // 도서 반납
  public int returnBook(String userId, int bookNo) {
    // 대출 테이블에서 해당 내역 삭제
    int result = rentRepository.returnBook(userId, bookNo);

    if (result == 1) {
      LocalDateTime returnDate = LocalDateTime.now();
      // 대출 테이블에서 삭제에 성공하였을 경우, 사용자 대출 내역에 반납일자 추가.
      return returnRepository.updateReturnedDate(userId, bookNo, returnDate);

    } else {
      return FAIL;
    }
  }

  // 사용자 대출 내역 조회
  public List<RentHistory> getRentHistory(String userId) {
    try{
      return returnRepository.getRentHistory(userId);
    }catch (Exception e) {
      return null;
    }
  }
}

