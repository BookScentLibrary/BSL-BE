package com.samsam.bsl.recommend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.recommend.repository.RecommendRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class RecommendListController {
	@Autowired RecommendRepository recommendRepository;
	
	// 사서 추천 도서 리스트
	@GetMapping("/recommendList")
	public List<Recommend> getUserList() {
		// 모든 사서 추천 도서 리스트 반환합니다.
		return recommendRepository.findAll();
	}
}
