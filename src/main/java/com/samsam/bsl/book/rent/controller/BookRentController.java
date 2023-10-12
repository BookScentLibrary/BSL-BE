package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.book.rent.service.BookService;
import com.samsam.bsl.book.rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/rent")
public class BookRentController {
    @Autowired
    RentService rentService;

    // 사용자 대출 도서 목록 조회
    @GetMapping("")
    public @ResponseBody List<RentedBook> getUsersRentBook(@RequestParam String username) {
        List<RentedBook> list = rentService.getUsersRentBookList(username);
        return list;
    }
    
    // 도서 대출
    @PostMapping("")
    public @ResponseBody String rentBook(@RequestBody Rent rent) {
        int code = rentService.rent(rent.getUsername(), rent.getBookNo());
        if (code == 1) {
            return "success";
        } else if (code == 2) {
            return "full rent";
        } else if (code == 3) {
            return "aleady rented";
        } else {
            return "fail";
        }
    }

    // 도서 반납
    @DeleteMapping("/return")
    public @ResponseBody String returnBook(@RequestBody Rent rent) {
        int code = rentService.returnBook(rent.getUsername(), rent.getBookNo());
        if (code == 1) {
            return "success";
        } else {
            return "fail";
        }
    }
}
