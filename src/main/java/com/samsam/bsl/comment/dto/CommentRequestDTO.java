package com.samsam.bsl.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDTO {
	int rev_postId;//글 번호
	String postTitle; // 게시글 제목
	String content; // 게시글 내용
	String userId; //userUUID
}
