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
				//.nickname(nickname)
				//.bookname(bookname)
				//.author(author)
				//.bookImageURL(bookImageURL)
				//.publisher(publisher)
				//.callNum(callNum)
				//.shelfArea(shelfArea)
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

	;

//	@Builder
//	public ReviewDTO(Review review) {
//		this.userId = review.getUserId();
//		this.bookNo = review.getBookNo();
//		this.rev_postId = review.getRev_postId();
//		this.postTitle = review.getPostTitle();
//		this.content = review.getContent();
//		this.createdAt = review.getCreatedAt();
//		this.modifiedAt = review.getModifiedAt();
//		this.isbn = review.getIsbn();
//		this.rate = review.getRate();
//		this.nickname = review.getUser().getNickname();
//		this.bookname = review.getBook().getBookname();
//		this.bookImageURL = review.getBook().getBookImageURL();
//		this.author = review.getBook().getAuthor();
//		this.publisher = review.getBook().getPublisher();
//		this.callNum = review.getBook().getCallNum();
//		this.shelfArea = review.getBook().getShelfArea();
//		this.comments = review.getComments().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
//	}

}