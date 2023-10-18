package com.samsam.bsl.book.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {
	String postTitle; // 게시글 제목
	String content; // 게시글 내용
	int bookNo; // 도서 번호
	String userId; // userUUID
	int rate;
	String isbn;
}
