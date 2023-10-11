package com.samsam.bsl.book.rent.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private int bookNo;
    private String bookImageURL;
    private String bookname;
    private String author;
    private String publisher;
    private String publicationYear;
    private String callNum;
    private String shelfarea;
    private String format;
    private String className;
    private int bookStatus;
    private int rentCnt;
    private String isbn;
    private String description;
}
