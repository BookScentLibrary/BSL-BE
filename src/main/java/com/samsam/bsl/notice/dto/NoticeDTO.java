package com.samsam.bsl.notice.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import com.samsam.bsl.notice.domain.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {
	private int not_postId;
	private String userId;
	private String postTitle;
	private String content;
	private String postImgURL;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private String nickname; 

	// NoticeDTO -> Notice
	public Notice toEntity() {
		Notice notice = Notice.builder()
				.userId(userId)
				.not_postId(not_postId)
				.postTitle(postTitle)
				.content(content)
				.postImgURL(postImgURL)
				.createdAt(createdAt)
				.modifiedAt(modifiedAt)
				.build();
		return notice;
	}
	
	@Builder
	public NoticeDTO(String userId, int not_postId, String postTitle, String content,String postImgURL,
			LocalDateTime createdAt, LocalDateTime modifiedAt, String nickname) { 
		this.userId = userId;
		this.not_postId = not_postId;
		this.postTitle = postTitle;
		this.content = content;
		this.postImgURL = postImgURL;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.nickname = nickname;
	}

//	@Builder
//	public NoticeDTO(Notice notice) {
//		this.userId = notice.getUserId();
//		this.not_postId = notice.getNot_postId();
//		this.postTitle = notice.getPostTitle();
//		this.content = notice.getContent();
//		this.postImgURL = notice.getPostImgURL();
//		this.createdAt = notice.getCreatedAt();
//		this.modifiedAt = notice.getModifiedAt();
//	}
}
