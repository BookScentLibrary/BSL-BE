package com.samsam.bsl.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.SignInDTO;
import com.samsam.bsl.user.dto.SignInResponseDTO;
import com.samsam.bsl.user.dto.SignUpDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;
import com.samsam.bsl.user.service.UserService;
import com.samsam.bsl.user.validator.UserInfoValidator;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserInfoValidator userInfoValidator;
	@Autowired
	private UserRepository userRepository;

	// 회원가입 요청
	@PostMapping("/signUp")
	public ResponseDTO<?> signUp(@RequestBody SignUpDTO signUpDTO) {
		System.out.println("[UserController] signup()");
		// 회원가입 정보 확인
		System.out.println(signUpDTO.toString());
		ResponseDTO<?> result = userService.signUp(signUpDTO);
		return result;
	}

	// 아이디 중복 검사
	@PostMapping("/idCheck")
	public ResponseDTO<?> idDueCheck(@RequestBody SignUpDTO signUpDTO) {
		String message = userInfoValidator.idDueCheck(signUpDTO);
		System.out.println(message);
		if (message == "이미 사용중인 아이디입니다.") {
			return ResponseDTO.setFailed(message);
		}
		return ResponseDTO.setSuccess(message, null);

	}

	// 닉네임 중복 검사
	@PostMapping("/nickCheck")
	public ResponseDTO<?> nickDueCheck(@RequestBody SignUpDTO signUpDTO) {
		String message = userInfoValidator.nickDueCheck(signUpDTO);
		System.out.println(message);
		if (message == "이미 사용중인 닉네임입니다.") {
			return ResponseDTO.setFailed(message);
		}
		return ResponseDTO.setSuccess(message, null);

	}

	// 로그인 요청
	@PostMapping("/signIn")
	public ResponseDTO<SignInResponseDTO> signIn(@RequestBody SignInDTO SignInDTO) {
		System.out.println("[UserController] signIn()");
		System.out.println(SignInDTO.toString());
		ResponseDTO<SignInResponseDTO> result = userService.signIn(SignInDTO);
		System.out.println("서비스 끝났다." + result);
		return result;
	}

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
