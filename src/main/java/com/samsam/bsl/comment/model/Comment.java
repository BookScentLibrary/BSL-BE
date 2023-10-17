package com.samsam.bsl.comment.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.comment.dto.CommentRequestDTO;
import com.samsam.bsl.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "comment_review")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId")
	private int commentId;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "createdAt", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "modifiedAt", nullable = false)
	private LocalDateTime modifiedAt;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false, nullable = false)
	private UserEntity user;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "rev_postId", referencedColumnName = "rev_postId", insertable = false, updatable = false, nullable = false)
	private Review Review;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private int rev_postId;
	
    // 댓글 생성
    public Comment(int rev_postId, CommentRequestDTO dto) {
		super();
		//현재 날짜와 시간
		LocalDateTime currentDate = LocalDateTime.now();
		
        this.rev_postId = rev_postId;
        this.userId = dto.getUserId();
		this.createdAt = currentDate; // 입력 날짜와 시간
		this.modifiedAt = currentDate; // 수정 날짜와 시간
        this.content = dto.getContent();
    }
}
