package com.samsam.bsl.book.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.review.dto.CommentDTO;
import com.samsam.bsl.book.review.service.CommentService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class CommentController {
//	private final CommentService commentService;
//
//    /* CREATE */
//    @PostMapping("/reviewDetail/{rev_postId}/{commentId}/comments")
//    public ResponseEntity<Long> save(@PathVariable Long id, @RequestBody CommentDTO.Request dto,
//                               @LoginUser UserDto.Response userSessionDto) {
//        return ResponseEntity.ok(commentService.save(id, userSessionDto.getNickname(), dto));
//    }
//
//    /* READ */
//    @GetMapping("/posts/{id}/comments")
//    public List<CommentDto.Response> read(@PathVariable Long id) {
//        return commentService.findAll(id);
//    }
//
//    /* UPDATE */
//    @PutMapping({"/posts/{postsId}/comments/{id}"})
//    public ResponseEntity<Long> update(@PathVariable Long postsId, @PathVariable Long id, @RequestBody CommentDto.Request dto) {
//        commentService.update(postsId, id, dto);
//        return ResponseEntity.ok(id);
//    }
//
//    /* DELETE */
//    @DeleteMapping("/posts/{postsId}/comments/{id}")
//    public ResponseEntity<Long> delete(@PathVariable Long postsId, @PathVariable Long id) {
//        commentService.delete(postsId, id);
//        return ResponseEntity.ok(id);
//    }
}
