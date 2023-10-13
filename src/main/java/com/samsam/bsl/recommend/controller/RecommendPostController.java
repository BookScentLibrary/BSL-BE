package com.samsam.bsl.recommend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.service.RecommendService;
import com.samsam.bsl.user.dto.ResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class RecommendPostController {
	
	@Autowired RecommendService recommendService;
	//게시글 작성
    @PostMapping("/createRecommend")
    public ResponseDTO<?> createRecommend(@RequestBody RecommendRequestDTO recommendDTO) {
    	ResponseDTO<?> result = recommendService.saveRecommend(recommendDTO);
        
        return result;
    }
}
