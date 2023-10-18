package com.samsam.bsl.book.review.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.user.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false, nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "bookNo", referencedColumnName = "bookNo", insertable = false, updatable = false, nullable = false)
    private Book book;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private int bookNo;


//	@Column(nullable = false)
//	private String nickname;
//
//	@Column(nullable = false)
//	private String bookname;
//
//	@Column(nullable = false)
//	private String bookImageURL;
//
//	@Column(nullable = false)
//	private String author;
//
//	@Column(nullable = false)
//	private String publisher;
//
//	@Column(nullable = false)
//	private String callNum;
//

//	@Column(nullable = false)
//	private String shelfArea;

    @OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("rev_postId") // 댓글 정렬
    private List<Comment> comments;

    /* 게시글 수정 메소드 */
    public void update(String postTitle, String content, int rate, int bookNo, String bookImageURL, String bookname,
                       String author, String publisher, String callNum, String shelfArea) {
        this.postTitle = postTitle;
        this.content = content;
        this.rate = rate;
        this.bookNo = bookNo;
    }
}