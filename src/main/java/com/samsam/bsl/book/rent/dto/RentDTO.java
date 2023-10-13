package com.samsam.bsl.book.rent.dto;

import com.samsam.bsl.book.rent.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentDTO {
    private String username;
    private List<Integer> bookNos;
}


