package com.samsam.bsl.user.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.SignUpDTO;
import com.samsam.bsl.user.repository.UserRepository;

@RestControllerAdvice
@Component
public class UserInfoValidator {

	private final UserRepository userRepository;

	public UserInfoValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// 회원가입 시, 유효성 체크
	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> fieldErrors = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			// 필드 이름을 오류 메시지의 키로 사용
			String fieldName = error.getField();
			String errorMessage = error.getDefaultMessage();
			fieldErrors.put(fieldName, errorMessage);
		}

		return fieldErrors;
	}

	// 필드 값의 유효성을 검사하는 메서드
	private boolean isValidField(String field, String pattern) {
		return Pattern.matches(pattern, field);
	}

	// 아이디 중복 체크
	public boolean checkUsernameDuplicate(String username) {
		return userRepository.existsByUsername(username);
	}

	// 닉네임 중복 체크
	public boolean checkNicknameDuplicate(String nickname) {
		return userRepository.existsByNickname(nickname);
	}

	// 아이디 중복 검사
	public String idDueCheck(SignUpDTO dto) {
		if (checkUsernameDuplicate(dto.getUsername())) {
			return "이미 사용중인 아이디입니다.";
		}
		return "사용가능한 아이디입니다.";
	}

	// 닉네임 중복 검사
	public String nickDueCheck(SignUpDTO dto) {
		if (checkNicknameDuplicate(dto.getNickname())) {
			return "이미 사용중인 닉네임입니다.";
		}
		return "사용가능한 닉네임입니다.";
	}
	
	  public ResponseDTO<?> getValidMessage(SignUpDTO dto) {
		    String username = dto.getUsername();
		    String password = dto.getPassword();
		    String passwordAgain = dto.getPasswordAgain();
			String email = dto.getEmail();
			String nickname = dto.getNickname();
			String phone = dto.getPhone();
			String userBirth = dto.getUserBirth();
			try {
				// 아이디 중복 체크
				if (checkUsernameDuplicate(username)) {
					return ResponseDTO.setFailed("이미 사용중인 아이디입니다.");
				}
			}catch (Exception e) {
				return ResponseDTO.setFailed("데이터베이스 오류입니다.");
			}
			
			try {
				// 닉네임 중복 체크
				if (checkNicknameDuplicate(nickname)) {
					return ResponseDTO.setFailed("이미 사용중인 닉네임입니다.");
				}
			}catch (Exception e) {
				return ResponseDTO.setFailed("데이터베이스 오류입니다.");
			}
		    //비밀번호가 서로 다르면 failed response반환!
		    if(!password.equals(passwordAgain)) {
		    	return ResponseDTO.setFailed("비밀번호가 일치하지 않습니다.");
		    }
		    // 아이디 검증
		    if (!isValidField(username, "^[a-zA-Z0-9]{8,20}$")) {
		      return ResponseDTO.setFailed("아이디는 영문(대소문자)과 숫자로 8자에서 20자 사이여야 합니다.");
		    }
		    // 비밀번호 검증
		    if (!isValidField(password, "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$")) {
		      return ResponseDTO.setFailed("비밀번호는 영문, 숫자, 특수문자(!, @, #, $, %, ^, &, *)로 8자에서 20자 사이여야 합니다.");
		    }
		    // 이메일 검증
		    if (!isValidField(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
		      return ResponseDTO.setFailed("이메일 형식이 올바르지 않습니다.");
		    }
		    // 닉네임 검증
		    if (!isValidField(nickname, "^[가-힣]{3,8}$")) {
		      return ResponseDTO.setFailed("닉네임은 한글 3자에서 8자 사이여야 합니다.");
		    }
		    // 연락처 검증
		    if (!isValidField(phone, "^[0-9]{11}$")) {
		      return ResponseDTO.setFailed("11자 숫자로('-'빼고) 연락처를 입력해주세요.");
		    }
		    // 생년월일 검증
		    if (!isValidField(userBirth, "^(19|20)\\d\\d(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$")) {
		      return ResponseDTO.setFailed("8자 숫자로(yyyyMMdd) 생년월일을 입력해주세요.");
		    }
		      // 모든 검사를 통과한 경우 리턴 (빈 맵)
		      return ResponseDTO.setSuccess("회원가입 성공", null);
		  }
}
