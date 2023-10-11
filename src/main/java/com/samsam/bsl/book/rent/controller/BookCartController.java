package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.domain.RentCommand;
import com.samsam.bsl.book.rent.dto.RentDTO;
import com.samsam.bsl.book.rent.service.BookService;
import com.samsam.bsl.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class BookCartController {

    @Autowired
    BookService bookService;

    @PostMapping("/rent")
    public @ResponseBody String rentBook(@RequestBody Rent rent) {
        int code = bookService.rent(rent.getUsername(), rent.getBookNo());
        if (code == 0) {
            return "성공 ^_^ ";
        } else {
            return "실패...";
        }
    }
}
