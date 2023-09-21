package com.samsam.bsl.review.dto;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CommentReviewDTO {	
	private int rev_postId;
	private int commentId;
	private String content;
	private String createdAt;
	private String modifiedAt;
	private int userNo;
	
	@Builder
	public CommentReviewDTO(int rev_postId, int commentId, String content, String createdAt, String modifiedAt,
			int userNo) {
		super();
		this.rev_postId = rev_postId;
		this.commentId = commentId;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.userNo = userNo;
	}
}
