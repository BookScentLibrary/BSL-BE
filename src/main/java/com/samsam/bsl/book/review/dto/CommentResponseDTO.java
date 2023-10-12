package com.samsam.bsl.book.review.dto;

import java.time.LocalDateTime;

import com.samsam.bsl.book.review.model.Comment;

import lombok.Getter;

@Getter
public class CommentResponseDTO {
	private int commentId;
	private int rev_postId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private int userNo;

	/* Entity -> Dto */
	public CommentResponseDTO(Comment comment) {
		this.commentId = comment.getCommentId();
		this.rev_postId = comment.getRev_postId();
		this.content = comment.getContent();
		this.createdAt = comment.getCreatedAt();
		this.modifiedAt = comment.getModifiedAt();
		this.userNo = comment.getUserNo();
	}

}
