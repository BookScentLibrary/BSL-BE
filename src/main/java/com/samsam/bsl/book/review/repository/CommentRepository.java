package com.samsam.bsl.book.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.book.review.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByCommentId(int commentId);
}
