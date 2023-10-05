package com.samsam.bsl.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.SignInDTO;
import com.samsam.bsl.user.dto.SignUpDTO;
import com.samsam.bsl.user.dto.SignInResponseDTO;
import com.samsam.bsl.user.service.UserService;
import com.samsam.bsl.user.validator.UserInfoValidator;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService userService;
	@Autowired UserInfoValidator userInfoValidator;
	
	//회원가입 요청
	@PostMapping("/signUp")  
	public ResponseDTO<?> signUp(@RequestBody SignUpDTO signUpDTO) {
		System.out.println("[UserController] signup()");
		System.out.println(signUpDTO.toString());
		ResponseDTO<?> result = userService.signUp(signUpDTO);
		return result;
	}
	
	// 아이디 중복 검사
	@PostMapping("/idCheck")
	public ResponseDTO<?> idDueCheck(@RequestBody SignUpDTO signUpDTO) {
		String message = userInfoValidator.idDueCheck(signUpDTO) ;
		System.out.println(message);
		if (message == "이미 사용중인 아이디입니다.") {
			return ResponseDTO.setFailed(message);
		} return ResponseDTO.setSuccess(message, null);
		
	}
	
	// 닉네임 중복 검사
	@PostMapping("/nickCheck")
	public ResponseDTO<?> nickDueCheck(@RequestBody SignUpDTO signUpDTO) {
		String message = userInfoValidator.nickDueCheck(signUpDTO) ;
		System.out.println(message);
		if (message == "이미 사용중인 닉네임입니다.") {
			return ResponseDTO.setFailed(message);
		} return ResponseDTO.setSuccess(message, null);
		
	}
	
	//로그인 요청
	@PostMapping("/signIn")
	public ResponseDTO<SignInResponseDTO> signIn(@RequestBody SignInDTO SignInDTO){
		ResponseDTO<SignInResponseDTO> result = userService.signIn(SignInDTO);
		return result;
	}
    
}
