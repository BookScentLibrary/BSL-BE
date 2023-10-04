package com.samsam.bsl.book.rent.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookEntity {
    @Id
    private int bookNo;
    @Column(length = 1000)
    private String bookImageURL;
    @Column(length = 100, nullable = false)
    private String bookname;
    @Column(length = 40, nullable = false)
    private String author;
    @Column(length = 40)
    private String publisher;
    @Column(length = 20)
    private String publicationYear;
    @Column(length = 40, nullable = false)
    private String callNum;
    @Column(length = 40)
    private String shelfarea;
    @Column(length = 40)
    private String format;
    @Column(length = 50)
    private String className;
    @Column(nullable = false)
    private int bookStatus;
    @Column(nullable = false)
    private int rentCnt;
    @Column(length = 20, nullable = false)
    private String isbn;
    @Column(nullable = true)
    private String description;
}
