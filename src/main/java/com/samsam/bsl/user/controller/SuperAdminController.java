package com.samsam.bsl.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;
import com.samsam.bsl.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superAdmin")
public class SuperAdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	// 유저 리스트
	@GetMapping("/userList")
	public List<UserEntity> getUserList() {
		// 모든 사용자 목록을 반환합니다.
		return userRepository.findAll();
	}

	// 유저 권한 승인 (0 일반유저 ->1 사서 )유저 권한 취소 (1 사서 -> 0 일반유저 ) 
	@PostMapping("/setPermission")
	public ResponseDTO<?> setPermission(@RequestBody Map<String, String> request) {
		String userId = request.get("userId");
	    Integer permission = Integer.parseInt(request.get("permission"));
		ResponseDTO<?> result = userService.updateUserPermission(userId, permission);
		return result;
	}
}
