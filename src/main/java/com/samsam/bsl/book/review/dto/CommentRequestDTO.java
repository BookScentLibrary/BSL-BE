package com.samsam.bsl.book.review.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.samsam.bsl.book.review.domain.Comment;
import com.samsam.bsl.book.review.domain.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDTO {

	private int commentId;
	private int rev_postId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private int userNo;
	private Review review;

	/* Dto -> Entity */
	public Comment toEntity() {
		Comment comments = Comment.builder().commentId(commentId).rev_postId(rev_postId).content(content)
				.createdAt(createdAt).modifiedAt(modifiedAt).userNo(userNo).review(review).build();
		return comments; 
	}
}
