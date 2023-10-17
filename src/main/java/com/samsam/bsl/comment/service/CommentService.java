package com.samsam.bsl.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.comment.dto.CommentRequestDTO;
import com.samsam.bsl.comment.model.Comment;
import com.samsam.bsl.comment.repository.CommentRepository;
import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

	// 댓글 작성
	public ResponseDTO<?> saveComment(int rev_postId, CommentRequestDTO dto) {
	Comment comment = new Comment(rev_postId, dto);
	try {
		// RecommendRepository를 이용해서 데이터베이스에 Entity 저장
		commentRepository.save(comment);
		return ResponseDTO.setSuccess("댓글 작성 성공", null);
	} catch (Exception e) {
		return ResponseDTO.setFailed("데이터베이스 오류입니다.");
	}
}
}
