package com.samsam.bsl.newbook;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewBookDTO {
  private int bookNo;
  private String bookname;
  private String author;
  private String publisher;
  private String publicationYear;
  private String regDate;
}