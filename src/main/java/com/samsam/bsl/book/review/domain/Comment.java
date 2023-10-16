package com.samsam.bsl.book.review.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.samsam.bsl.notice.domain.Notice;
import com.samsam.bsl.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment_review")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int commentId;

	@Column(nullable = false)
	private int rev_postId;

	@Column(nullable = false)
	private String content;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime modifiedAt;

	@Column(nullable = false)
	private int userNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rev_postId", referencedColumnName = "rev_postId", insertable = false, updatable = false, nullable = false)
	private Review review;
	
	@Builder
	public Comment(int commentId, int rev_postId, String content, LocalDateTime createdAt, LocalDateTime modifiedAt, int userNo) {
		this.commentId = commentId;
		this.rev_postId = rev_postId;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.userNo = userNo;
	}

}
