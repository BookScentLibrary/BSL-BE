package com.samsam.bsl.book.rent.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Builder
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(name="bookNo")
    private int bookNo;

    @Column(name="bookImageURL")
    private String bookImageURL;

    @Column(name="bookname")
    private String bookname;

    @Column(name="author")
    private String author;

    @Column(name="publisher")
    private String publisher;

    @Column(name="publicationYear")
    private String publicationYear;

    @Column(name="callNum")
    private String callNum;

    @Column(name="shelfArea")
    private String shelfArea;

    @Column(name="format")
    private String format;

    @Column(name="className")
    private String className;

    @Column(name="bookStatus")
    private int bookStatus;

    @Column(name="rentCnt")
    private int rentCnt;

    @Column(name="isbn")
    private String isbn;

    @Column(name="description")
    private String description;

    @Column(name="regDate")
    private String regDate;
}
