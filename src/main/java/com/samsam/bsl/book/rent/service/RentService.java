package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Cart;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.dto.CartDTO;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.CartRepository;
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

    @Autowired
    CartRepository cartRepository;

    // 도서 대출
    public int rent(String userId, int bookNo) {
        // 도서 대출 상태값 조회 (대출가능:0/대출불가:1)
        int status = bookRepository.getBook(bookNo).getBookStatus();
        if (status != 0) {
            return ALEADY_RENTED_BOOK;
        }
        // 사용자 유무 확인
        Optional user = userRepository.findById(userId);

        // 현재 사용자가 대출중인 도서 권수 확인
        int bookCnt = rentRepository.RentedBookCnt(userId);

        // 사용자가 존재하며, 대출 권수가 3권 미만일 경우 대출 루트 진입
        if (user.isPresent() && bookCnt < 3) {
            // 대출일자-반납예정일자 지정
            LocalDateTime rentDate = LocalDateTime.now();
            LocalDateTime expireDate = rentDate.plusDays(7).with(LocalTime.MIDNIGHT);
            Rent rent = new Rent(userId, bookNo, rentDate.toString(), expireDate.toString());
            // 도서 대출 상태값(bookStatue) 변경
            int updateResult = rentRepository.updateBookStatus(userId, bookNo);

            // 상태값 변경 성공시 대출 시작
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
                // 사용자가 이미 3권의 책을 대출중인 경우
                return FULL_RENT;
            } else if (user.isEmpty()) {
                // 사용자가 존재하지 않을 경우
                return NOT_FOUND_USER;
            } else {
                // 그 외
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
            // 성공하여 행이 변경되었을 경우 1 반환. 
            return returnRepository.updateReturnedDate(userId, bookNo, returnDate);
        } else {
            return FAIL;
        }
    }

    // 사용자 대출 내역 조회
    public List<RentHistory> getRentHistory(String userId) {
        try {
            return returnRepository.getRentHistory(userId);
        } catch (Exception e) {
            return null;
        }
    }

    // 책바구니 추가
    public int addCart(CartDTO cart) {
        try {
            // 사용자와 책번호가 중복된 행 검색
            if (cartRepository.findByUserIdAndBookNo(cart.getUserId(), cart.getBookNo()) == null) {
                // 중복된 행이 없을 경우 책바구니 추가
                Cart c = new Cart();
                c.setBookNo(cart.getBookNo());
                c.setUserId(cart.getUserId());
                Cart save = cartRepository.save(c);

                return SUCCESS;
            } else {
                // 이미 장바구니에 담긴 책일 경우
                return ALEADY_RENTED_BOOK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    // 책바구니 내역 조회
    public List<Cart> getCart(String userId) {
        try {
            return cartRepository.findAllByUserIdOrderByIdDesc(userId);
        } catch (Exception e) {
            return null;
        }
    }

    public int cleanCart(String userId) {
        try {
            int count = cartRepository.countByUserId(userId);
            if (count == 0) {
                return 1;
            }
            List<Cart> deletedBook = cartRepository.deleteByUserId(userId);
            return deletedBook.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
