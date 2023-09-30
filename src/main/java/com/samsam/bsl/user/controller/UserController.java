package com.samsam.bsl.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.service.UserService;
import com.samsam.bsl.user.validator.UserInfoValidator;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	private final UserInfoValidator userInfoValidator;

	@PostMapping("/signup")
	public Map<String, Object> signup(@RequestBody UserDTO user, Errors errors) {
	    Map<String, Object> response = new HashMap<>();
	    
	    Map<String, String> message = userInfoValidator.getValidMessage(user, errors);
	    System.out.println(message);
	    
	    String messageValue = message.get("message");
	    if (messageValue != null && messageValue.equals("회원가입 성공")) {
	        response.put("success", true);
	        response.put("message", "회원가입 성공");
	        response.put("data", userService.signup(user));
	    } else {
	        response.put("fail", false);
	        response.put("message", "회원가입 실패");
	        response.put("errors", message); // 필드별 오류 메시지를 errors 키에 넣어서 전달
	    }
	    return response;
	}

	// 아이디 중복 검사
	@PostMapping("/idCheck")
	public ResponseDTO idDueCheck(@RequestBody UserDTO user) {
		String message = userInfoValidator.idDueCheck(user) ;
		System.out.println(message);
		if (message == "이미 사용중인 아이디입니다.") {
			return new ResponseDTO(false, message);
		} return new ResponseDTO(true, message);
		
	}
	
	// 닉네임 중복 검사
	@PostMapping("/nickCheck")
	public ResponseDTO nickDueCheck(@RequestBody UserDTO user) {
		String message = userInfoValidator.nickDueCheck(user) ;
		System.out.println(message);
		if (message == "이미 사용중인 닉네임입니다.") {
			return new ResponseDTO(false, message);
		} return new ResponseDTO(true, message);
		
	}
	
//	@PostMapping("/signup")
//	public String signup(@RequestBody UserDTO user, Errors errors) {
//		System.out.println("SIGNUP USERNAME : "+user.getUsername());
//		System.out.println("SIGNUP NICKNAME : "+user.getNickname());
//		System.out.println("SIGNUP EMAIL : "+user.getEmail());
//		userService.signup(user);
//      String message = userInfoValidator.getValidMessage(user, errors);
//      System.out.println(message);
//		return "OK";
//	}
	
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
