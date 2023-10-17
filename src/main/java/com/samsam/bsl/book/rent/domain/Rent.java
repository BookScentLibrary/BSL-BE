package com.samsam.bsl.book.rent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PK;
    private String userId;
    @JsonIgnore
    private int bookNo;
    private String rentDate;
    private String expireDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
    private Book book;

    public Rent(String userId, int bookNo, String rentDate, String expireDate) {
        this.userId = userId;
        this.bookNo = bookNo;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
    }
}
