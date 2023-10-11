package com.samsam.bsl.book.review.model;

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

import org.hibernate.annotations.CreationTimestamp;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "post_review")
public class Review {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rev_postId;

	@Column(nullable = false)
	private String postTitle;

	@Column(nullable = false)
	private String content;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime createdAt;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime modifiedAt;

	@Column(nullable = false)
	private String isbn;

	@Column(nullable = false)
	private int rate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false, nullable = false)
	private UserEntity user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
	private Book book;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private int bookNo;

}