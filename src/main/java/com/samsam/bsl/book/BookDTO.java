package com.samsam.bsl.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
	  private int bookNo;
	  private String bookImageURL;
	  private String bookname;
	  private String author;
	  private String publisher;
	  private String publicationYear;
	  private String callNum;
	  private String shelfarea;
	  private String format;
	  private String className;
	  private int bookStatus;
	  private int rentCnt;
	  private String isbn;
	  private String description;
}
