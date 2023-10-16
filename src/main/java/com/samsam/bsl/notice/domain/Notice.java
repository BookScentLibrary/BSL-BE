package com.samsam.bsl.notice.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post_notice")
public class Notice {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int not_postId;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private String postTitle;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private String postImgURL;

	@Column
	private Long imgId;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime modifiedAt;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false, nullable = false)
	private UserEntity user;

//	@OneToMany(mappedBy = "notice")
//	private List<Images> uploadImages = new ArrayList<>();

	@Builder
	public Notice(int not_postId, String userId, String postTitle, String content, String postImgURL, Long imgId) {
		this.not_postId = not_postId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.content = content;
		this.postImgURL = postImgURL;
		this.imgId = imgId;
	}
}
