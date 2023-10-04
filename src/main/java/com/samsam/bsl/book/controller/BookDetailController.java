package com.samsam.bsl.book.controller;

import com.samsam.bsl.book.dto.BookDTO;
import com.samsam.bsl.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/detail")
public class BookDetailController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public BookDTO getBook() {
        BookDTO book = new BookDTO();
        book.setBookNo(00000001);
        book.setBookImageURL("https://image.aladin.co.kr/product/19359/16/cover/s972635417_1.jpg");
        book.setBookname("책제목");
        book.setAuthor("작가");
        book.setPublisher("출판사");
        book.setPublicationYear("2019");
        book.setCallNum("813.7");
        book.setShelfarea("책위치");
        book.setFormat("책형태정보");
        book.setClassName("도서장르정보");
        book.setBookStatus(0);
        book.setRentCnt(10);
        book.setIsbn("9791190090018");
        book.setDescription("책 상세정보");



        return book;
    }
}
