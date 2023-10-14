package com.samsam.bsl.mainpage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainNotice {
    private int pro_postId;
    private String postTitle;
    private String createdAt;
}
