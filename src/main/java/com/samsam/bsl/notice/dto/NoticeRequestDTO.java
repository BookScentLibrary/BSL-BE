package com.samsam.bsl.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDTO {
	String postTitle; // 게시글 제목
	String content; // 게시글 내용
	String userId; //userUUID
	String postImgURL;
}
