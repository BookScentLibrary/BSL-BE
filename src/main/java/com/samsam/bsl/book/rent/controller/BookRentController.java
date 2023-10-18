package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.Cart;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.dto.CartDTO;
import com.samsam.bsl.book.rent.dto.RentDTO;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.book.rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/rent")
public class BookRentController {

    @Autowired
    RentService rentService;

    // 사용자 대출 도서 목록 조회
    @GetMapping("")
    public @ResponseBody List<RentedBook> getUsersRentBook(@RequestParam String userId) {
        List<RentedBook> list = rentService.getUsersRentBookList(userId);
        return list;
    }

    // 사용자 대출 내역 조회
    @GetMapping("/history")
    public @ResponseBody List<RentHistory> getRentHistory(@RequestParam String userId) {
        List<RentHistory> books = rentService.getRentHistory(userId);
        return books;
    }

    // 도서 대출
    @PostMapping("")
    public @ResponseBody String rentBook(@RequestBody RentDTO rent) {
        int code = rentService.rent(rent.getUserId(), rent.getBookNo());
        if (code == 1) {
            return "success";
        } else if (code == 2) {
            return "full rent";
        } else if (code == 3) {
            return "aleady rented";
        } else if (code == 4) {
            return "not found user";
        } else {
            return "fail";
        }
    }

    // 도서 반납
    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody RentDTO rent) {
        int code = rentService.returnBook(rent.getUserId(), rent.getBookNo());
        if (code == 1) {
            return ResponseEntity.status(HttpStatus.OK).body("도서 반납 성공");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("도서 반납 실패");
        }
    }

    // 책바구니 추가
    @PostMapping("/cart")
    public @ResponseBody String addCart(@RequestBody CartDTO cart) {
        int code = rentService.addCart(cart);
        if (code == 1) {
            return "success";
        } else if (code == 3) {
            return "already added";
        } else {
            return "fail";
        }
    }

    // 책바구니 조회
    @GetMapping("/cart")
    public ResponseEntity<?> getCart(@RequestParam String userId) {
        List<Cart> list = rentService.getCart(userId);
        if (list != null) {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
    }

    // 책바구니 전체 비우기
    @DeleteMapping("/cart")
    public ResponseEntity<?> cleanCart(@RequestParam String userId) {
        int code = rentService.cleanCart(userId);
        if (code > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("요청 처리에 성공했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("요청 처리에 실패했습니다.");
        }
    }

}
