package com.samsam.bsl.user.controller;

import java.util.HashMap;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;


	@PostMapping("/signup")
	public String signup(@RequestBody UserDTO user) {
		System.out.println("SIGNUP USERNAME : "+user.getUsername());
		System.out.println("SIGNUP NICKNAME : "+user.getNickname());
		System.out.println("SIGNUP EMAIL : "+user.getEmail());
		return "OK";
	}

	//회원가입 요청
//	@PostMapping("/signup")
//	public String signup(UserDTO user) {
//		System.out.println("[UserController] signup()");
//		return "회원가입 테스트";
//	}

//	public ResponseEntity<HashMap<String, String>> signup(
//								@RequestParam(value = "username") String username,
//								@RequestParam(value = "password") String password,
//								@RequestParam(value = "email") String email,
//								@RequestParam(value = "nickname") String nickname,
//								@RequestParam(value = "phone") String phone,
//								@RequestParam(value = "gender") String gender,
//								@RequestParam(value = "userBirth") String userBirth,
//								@RequestParam(value = "userAge") int userAge
//								) {
//		System.out.println("[UserController] signup()");
//		
//		UserDTO userDTO = new UserDTO(username, password, email, nickname, phone, gender, userBirth, userAge);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(userService.signup(userDTO));
//	}

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
//        try {
//            // 서버 측에서 유효성 검사 수행
//            userService.signupValidate(userDTO);
//            // 저장 로직 및 성공 응답
//            return new ResponseEntity<>("회원 가입 성공", HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            // 유효성 검사 오류 발생 시 클라이언트에게 오류 응답
//            HashMap<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", e.getMessage());
//            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//        }
//    }
    
}
