package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.domain.RentCommand;
import com.samsam.bsl.book.rent.dto.RentDTO;
import com.samsam.bsl.book.rent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class BookCartController {

    @Autowired
    BookService bookService;

    @PostMapping("/rent")
    public @ResponseBody String rentBook(@RequestBody RentCommand rentDto) {
    RentCommand rentCommand = rentDto.toCommand();
    bookService.rent(rentDto.getUserId(), rentDto.getBookNo());
        return "";
    }

}
