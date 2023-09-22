package com.samsam.bsl.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.user.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	//회원 가입
	@PostMapping("/signup")
	public String signup(UserDTO user) {
		System.out.println("[UserController] signup()");
		String nextPage = "회원가입테스트";
		return nextPage;
	}

}
