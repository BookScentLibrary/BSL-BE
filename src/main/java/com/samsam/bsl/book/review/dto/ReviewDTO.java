package com.samsam.bsl.book.review.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.samsam.bsl.book.review.domain.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDTO {
	private String userId;
	private int bookNo;
	private int rev_postId;
	private String postTitle;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private String isbn;
	private int rate;
	private String nickname; // Users 테이블의 nickname 필드 추가
	private String bookname; // Books 테이블의 bookname 필드 추가

	private String bookImageURL;
	private String author;
	private String publisher;
	private String callNum;
	private String shelfArea;

	private List<CommentResponseDTO> comments;


	//ReviewDTO ->  Review
	public Review toEntity() {
		Review review = Review.builder()
				.userId(userId)
				.bookNo(bookNo)
				.rev_postId(rev_postId)
				.postTitle(postTitle)
				.content(content)
				.isbn(isbn)
				.createdAt(createdAt)
				.modifiedAt(modifiedAt)
				.rate(rate)
				.build();
		return review;
	}

	@Builder
	public ReviewDTO(String userId, int bookNo, int rev_postId, String postTitle, String content,
					 LocalDateTime createdAt, LocalDateTime modifiedAt, String isbn, int rate, String nickname,
			           String bookname, String bookImageURL, String author, String publisher, String callNum,
			           String shelfArea, List<CommentResponseDTO> comments) {

		this.userId = userId;
		this.bookNo = bookNo;
		this.rev_postId = rev_postId;
		this.postTitle = postTitle;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isbn = isbn;
		this.rate = rate;
		this.nickname = nickname;
		this.bookname = bookname;
		this.bookImageURL = bookImageURL;
		this.author = author;
		this.publisher = publisher;
		this.callNum = callNum;
		this.shelfArea = shelfArea;
		this.comments = comments;
		//this.comments = review.getComments().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
	}

//	@Builder
//	public ReviewDTO(Review review) {

}
