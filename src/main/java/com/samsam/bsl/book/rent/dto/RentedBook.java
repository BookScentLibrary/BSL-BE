package com.samsam.bsl.book.rent.dto;

import com.samsam.bsl.book.rent.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentedBook {
        private Book book;
        private String rentDate;
        private String expireDate;
}
