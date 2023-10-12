package com.samsam.bsl.recommend.model;

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

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
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
@Table(name = "post_recommend")
public class Recommend {
	
	@Id
	@Column(name = "rec_postId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recPostId;

    @Column(name = "postTitle", length = 40, nullable = false)
    private String postTitle;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modifiedAt", nullable = false)
    private LocalDateTime modifiedAt;
    
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
	
	//생성자
	public Recommend(RecommendRequestDTO dto) {
		super();
		//현재 날짜와 시간
		LocalDateTime currentDate = LocalDateTime.now();
		
		this.postTitle = dto.getPostTitle(); //게시글 제목
		this.content = dto.getContent(); // 게시글 내용
		this.createdAt = currentDate; // 입력 날짜와 시간
		this.modifiedAt = currentDate; // 수정 날짜와 시간
		this.userId = dto.getUserId(); // userUUID
		this.bookNo = dto.getBookNo(); // 도서 번호
	}
}
