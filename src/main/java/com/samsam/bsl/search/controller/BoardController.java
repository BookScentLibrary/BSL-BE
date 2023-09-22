package com.samsam.bsl.search.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.samsam.bsl.search.service.BoardService;

@Controller
public class BoardController {

	private Map<String, bookNoSearchResult>bookMap;
	
	@PostConstruct
	public void init() {
		bookMap= new HashMap<String,bookNoSearchResult >();
		bookMap.put("00000001",)
		//여기 부분은 데이터 넣는 부분인거 같은데 잘 모르겠음
		//유튜브 스프링 부트 10분만에 mysql과 mybatis 연동하는 법 슬기로운 코딩생활보면 됨
		//10분 11초
	}
	
	
	
}
