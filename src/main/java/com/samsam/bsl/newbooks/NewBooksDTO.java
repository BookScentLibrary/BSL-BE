package com.samsam.bsl.newbooks;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBooksDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookCnt;
    private String bookname;
    private String author;
    private String publisher;
    private String publicationYear;
    private String regDate;
}