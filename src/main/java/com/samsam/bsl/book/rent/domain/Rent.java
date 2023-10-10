package com.samsam.bsl.book.rent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Builder
@Table(name="rent")
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    @Id
    private String userId;
    private int bookNo;
}
