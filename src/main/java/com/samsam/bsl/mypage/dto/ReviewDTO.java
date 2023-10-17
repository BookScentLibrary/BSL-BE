package com.samsam.bsl.mypage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
  private int rev_postId;
  private String postTitle;
  private int bookNo;
  private LocalDateTime createdAt;
}
