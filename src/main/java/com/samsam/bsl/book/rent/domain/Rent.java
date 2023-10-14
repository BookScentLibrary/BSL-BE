package com.samsam.bsl.book.rent.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@Table(name="rent")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PK;
    private String username;
    private int bookNo;
    private String rentDate;
    private String expireDate;

    public Rent(String username, int bookNo, String rentDate, String expireDate) {
        this.username = username;
        this.bookNo = bookNo;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
    }
}
