package com.samsam.bsl.book.rent.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDTO {
    private int bookNo;
    private String userId;
}
