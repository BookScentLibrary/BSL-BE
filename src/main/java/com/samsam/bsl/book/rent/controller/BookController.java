package com.samsam.bsl.book.rent.controller;

import com.samsam.bsl.book.rent.dto.BookDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/")
    public @ResponseBody BookDTO testApi() {
        System.out.println("test api 동작");
        BookDTO book = new BookDTO();

        book.setBookNo(00000001);
        book.setBookImageURL("https://image.aladin.co.kr/product/19359/16/cover/s972635417_1.jpg");
        book.setBookname("우리가 빛의 속도로 갈 수 없다면");
        book.setAuthor("김초엽");
        book.setPublisher("허블");
        book.setPublicationYear("2019");
        book.setCallNum("813.7");
        book.setShelfarea("[논현]큰글자도서");
        book.setFormat("책형태정보");
        book.setClassName("문학 > 한국문학 > 소설");
        book.setBookStatus(0);
        book.setRentCnt(10);
        book.setIsbn("9791190090018");
        book.setDescription("2017년 '관내분실'과 '우리가 빛의 속도로 갈 수 없다면'으로 제2회 한국과학문학상 중단편 대상과 가작을 수상하며 작품 활동을 시작한 김초엽 작품집. '순례자들은 왜 돌아오지 않는가', '스펙트럼', '공생가설', '우리가 빛의 속도로 갈 수 없다면', '감정의 물성', '관내분실', '나의 우주 영웅에 관하여'가 수록되었다.");

        return book;
    }
}
