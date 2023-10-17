package com.samsam.bsl.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.comment.dto.CommentRequestDTO;
import com.samsam.bsl.comment.repository.CommentRepository;
import com.samsam.bsl.comment.service.CommentService;
import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.user.dto.ResponseDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@RestController
public class CommentController {

	@Autowired CommentService commentService;
	@Autowired CommentRepository commentRepository;
	
	//댓글 작성하기
    @PostMapping("/commentCreate/{rev_postId}")
    public ResponseDTO<?> recommendCreate(@PathVariable int rev_postId,@RequestBody CommentRequestDTO commentRequestDTO) {
    	ResponseDTO<?> result = commentService.saveComment(rev_postId, commentRequestDTO);
        
        return result;
    }
}
