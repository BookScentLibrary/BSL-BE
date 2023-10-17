package com.samsam.bsl.comment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samsam.bsl.comment.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	Page<Comment> findAllByPostIdOrderByCreatedAtDesc(Long postId , Pageable pageable);

}
