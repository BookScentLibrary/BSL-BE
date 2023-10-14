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
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDTO {
	private int not_postId;
	private String userId;
	private String postTitle;
	private String content;
	private String postImgURL;
	private Long imgId;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private String nickname;

	// NoticeDTO -> Notice
	public Notice toEntity() {
		Notice notice = Notice.builder().not_postId(not_postId).userId(userId).postTitle(postTitle).content(content)
				.postImgURL(postImgURL).imgId(imgId).imgId(imgId).build();
		return notice;
	}

	@Builder
	public NoticeDTO(int not_postId, String userId, String postTitle, String content, String postImgURL, Long imgId,
			LocalDateTime createdAt, LocalDateTime modifiedAt, String nickname) {
		this.not_postId = not_postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.content = content;
		this.postImgURL = postImgURL;
		this.imgId = imgId;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.nickname = nickname;
	}
}
