package com.samsam.bsl.review.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PostReviewDTO {
	private String userId;
	private int bookNo;
	private int rev_postId;
	private String postTitle;
	private String content;
	private String createdAt;
	private String modifiedAt;
	private String isbn;
	
	@Builder
	public PostReviewDTO(String userId, int bookNo, int rev_postId, String postTitle, String content, String createdAt,
			String modifiedAt, String isbn) {
		super();
		this.userId = userId;
		this.bookNo = bookNo;
		this.rev_postId = rev_postId;
		this.postTitle = postTitle;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isbn = isbn;
	}
}
