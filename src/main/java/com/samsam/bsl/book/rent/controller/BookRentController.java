package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.dto.RentDTO;
import com.samsam.bsl.book.rent.dto.RentedBook;
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
        System.out.println(rent);
        int code = rentService.rent(rent.getUserId(), rent.getBookNo());
        System.out.println(code);
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
    @DeleteMapping("/return")
    public @ResponseBody String returnBook(@RequestBody RentDTO rent) {
        int code = rentService.returnBook(rent.getUserId(), rent.getBookNo());
        if (code == 1) {
            return "success";
        } else {
            return "fail";
        }
    }
}
