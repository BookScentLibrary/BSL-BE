package com.samsam.bsl.review.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.samsam.bsl.review.model.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
public class ReviewDTO {
	private String userId;
	private int bookNo;
	private int rev_postId;
	private String postTitle;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private String isbn;
	private int rate;
	private String nickname; // Users 테이블의 nickname 필드 추가
	private String bookname; // Books 테이블의 bookname 필드 추가

	public Review toEntity() {
		Review review = Review.builder().userId(userId).bookNo(bookNo).rev_postId(rev_postId).postTitle(postTitle)
				.content(content).isbn(isbn).rate(rate).build();
		return review;
	}

	@Builder
	public ReviewDTO(String userId, int bookNo, int rev_postId, String postTitle, String content,
			LocalDateTime createdAt, LocalDateTime modifiedAt, String isbn, int rate, String nickname,
			String bookname) {
		this.userId = userId;
		this.bookNo = bookNo;
		this.rev_postId = rev_postId;
		this.postTitle = postTitle;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isbn = isbn;
		this.rate = rate;
		this.nickname = nickname;
		this.bookname = bookname;
	}
}
