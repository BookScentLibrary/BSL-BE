package com.samsam.bsl.review.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.samsam.bsl.book.model.Book;
import com.samsam.bsl.users.model.Users;

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
@Table(name = "post_review")
@Builder
public class Review {

	@Column(name = "userid")
    private String userId;

    @Column(name = "bookno")
    private int bookNo;

    @Id
    @Column(name = "rev_postid")
    private int rev_postId;

    @Column(name = "posttitle")
    private String postTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "createdat")
    private LocalDateTime createdAt;

    @Column(name = "modifiedat")
    private LocalDateTime modifiedAt;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "bookscore")
    private int bookScore;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "bookno", referencedColumnName = "bookno", insertable = false, updatable = false)
    private Book book;
    
//    @Column(name = "nickname")
//    private String nickname;
//
//    @Column(name = "bookname")
//    private String bookname;


}