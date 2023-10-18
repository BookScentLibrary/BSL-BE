package com.samsam.bsl.mainpage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainReview {
    private int rev_postId;
    private String nickname;
    private String postTitle;
    private String bookname;
    private String createdAt;
}
