package com.samsam.bsl.review.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BooksDTO {
	private int bookNo;
	private String bookImageURL;
	private String bookname;
	private String authors;
	private String publisher;
	private String publicationYear;
	private String callNum;
	private String area;
	private String format;
	private String className;
	private int bookStatus;
	private int rentCnt;
	private String isbn;
	private String description;

	@Builder
	public BooksDTO(int bookNo, String bookImageURL, String bookname, String authors, String publisher,
			String publicationYear, String callNum, String area, String format, String className, int bookStatus,
			int rentCnt, String isbn, String description) {
		super();
		this.bookNo = bookNo;
		this.bookImageURL = bookImageURL;
		this.bookname = bookname;
		this.authors = authors;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.callNum = callNum;
		this.area = area;
		this.format = format;
		this.className = className;
		this.bookStatus = bookStatus;
		this.rentCnt = rentCnt;
		this.isbn = isbn;
		this.description = description;
	}
}
