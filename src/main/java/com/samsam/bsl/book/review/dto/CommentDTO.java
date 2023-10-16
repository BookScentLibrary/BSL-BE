package com.samsam.bsl.book.review.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.samsam.bsl.book.review.domain.Comment;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.notice.domain.Notice;
import com.samsam.bsl.notice.dto.NoticeDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
	private int commentId;
	private int rev_postId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private int userNo;
	private Review review;
	
	// NoticeDTO -> Notice
		public Comment toEntity() {
			Comment comment = Comment.builder()
					.commentId(commentId)
					.rev_postId(rev_postId)
					.content(content)
					.createdAt(createdAt)
					.modifiedAt(modifiedAt)
					.userNo(userNo).build();
			return comment;
		}

		@Builder
		public CommentDTO(int commentId, int rev_postId, String content, LocalDateTime createdAt, LocalDateTime modifiedAt, int userNo) {
			this.commentId = commentId;
			this.rev_postId = rev_postId;
			this.content = content;
			this.createdAt = createdAt;
			this.modifiedAt = modifiedAt;
			this.userNo = userNo;
		}
}
