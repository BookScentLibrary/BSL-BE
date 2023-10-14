package com.samsam.bsl.recommend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.dto.RecommendUpdateRequestDTO;
import com.samsam.bsl.recommend.service.RecommendService;
import com.samsam.bsl.user.dto.ResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class RecommendPostController {
	
	@Autowired RecommendService recommendService;
	//게시글 작성
    @PostMapping("/recommendCreate")
    public ResponseDTO<?> recommendCreate(@RequestBody RecommendRequestDTO recommendDTO) {
    	ResponseDTO<?> result = recommendService.saveRecommend(recommendDTO);
        
        return result;
    }
    
    //게시글 수정
    @PutMapping("/recommendUpdate/{recPostId}")
    public ResponseDTO<?> recommendUpdate(@PathVariable int recPostId,  @RequestBody RecommendUpdateRequestDTO recommendUpdateRequestDTO) {
    	ResponseDTO<?> result = recommendService.updateRecommend(recPostId, recommendUpdateRequestDTO);
    	System.out.println("recommendUpdate : " + result);
        
        return result;
    }
    // 게시글 삭제
    @DeleteMapping("/recommendDelete/{recPostId}")
    public ResponseDTO<?> recommendDelete(@PathVariable int recPostId) {
    	System.out.println("recommendDelete 시작");
        ResponseDTO<?> result = recommendService.deleteRecommend(recPostId);
    	System.out.println("recommendDelete : " + result);
        
        return result;
    }
}
