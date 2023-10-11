package com.samsam.bsl.book.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "bookno")
	private int bookNo;

	@Column(name = "bookimageurl")
	private String bookImageURL;

	private String bookname;
	private String authors;
	private String publisher;

	@Column(name = "publicationyear")
	private String publicationYear;

	@Column(name = "callnum")
	private String callNum;

	private String area;
	private String format;

	@Column(name = "classname")
	private String className;

	@Column(name = "bookstatus")
	private int bookStatus;

	@Column(name = "rentcnt")
	private int rentCnt;

	private String isbn;
	private String description;

}