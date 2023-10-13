package com.samsam.bsl.mainpage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainRecomm {
    private int rec_postId;
    private String bookname;
    private String author;
    private String content;
    private String bookImageUrl;
}
