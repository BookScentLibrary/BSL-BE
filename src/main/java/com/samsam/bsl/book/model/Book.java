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
	@Column(nullable = false)
	private int bookNo;

	@Column(nullable = false)
	private String bookImageURL;

	@Column(nullable = false)
	private String bookname;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String publisher;

	@Column(nullable = false)
	private String publicationYear;

	@Column(nullable = false)
	private String callNum;

	@Column(nullable = false)
	private String shelfArea;
	
	@Column(nullable = false)
	private String format;

	@Column(nullable = false)
	private String className;

	@Column(nullable = false)
	private int bookStatus;

	@Column(nullable = false)
	private int rentCnt;

	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private String description;

}