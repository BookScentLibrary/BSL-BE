package com.samsam.bsl.book.rent.dto;

import com.samsam.bsl.book.rent.domain.Book;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentDTO {
    private String userId;
    private int bookNo;
}


