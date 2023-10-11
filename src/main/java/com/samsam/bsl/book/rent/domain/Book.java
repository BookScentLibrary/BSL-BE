package com.samsam.bsl.book.rent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
