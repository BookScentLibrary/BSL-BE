package com.samsam.bsl.book.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.book.review.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
