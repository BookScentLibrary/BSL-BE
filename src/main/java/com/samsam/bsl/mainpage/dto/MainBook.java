package com.samsam.bsl.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainBook {
    private String bookname;
    private String bookImageURL;
    private String author;
    private int bookNo;
}
