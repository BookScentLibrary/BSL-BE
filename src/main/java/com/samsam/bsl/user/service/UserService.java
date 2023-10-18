package com.samsam.bsl.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.SignInDTO;
import com.samsam.bsl.user.dto.SignInResponseDTO;
import com.samsam.bsl.user.dto.SignUpDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;
import com.samsam.bsl.user.security.TokenProvider;
import com.samsam.bsl.user.validator.UserInfoValidator;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserInfoValidator userInfoValidator;
	@Autowired
	TokenProvider tokenProvider;

	private final PasswordEncoder passwordEncoder;
	
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
  
	// 회원가입
	public ResponseDTO<?> signUp(SignUpDTO dto) {
		// 유효성 검사
		if (userInfoValidator.getValidMessage(dto).isResult()) {
			// 비밀번호 암호화
			String encodedPassword = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(encodedPassword);

			// UserEntity 생성
			UserEntity userEntity = new UserEntity(dto);
			try {
				// UserRepository를 이용해서 데이터베이스에 Entity 저장
				userRepository.save(userEntity);
				// 성공시 success response반환
				return ResponseDTO.setSuccess("회원가입 성공", null);
			} catch (Exception e) {
				return ResponseDTO.setFailed("데이터베이스 오류입니다.");
			}
		}
		// 실패 시 에러 response 반환
	    return ResponseDTO.setFailed("유효성 검사 실패");
	}

	// 로그인
	public ResponseDTO<SignInResponseDTO> signIn(SignInDTO dto) {
		String username = dto.getUsername();
		String userPassword = dto.getPassword();

		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findByUsername(username);
			// 아이디 못 찾을때
			if (userEntity == null) {
				return ResponseDTO.setFailed("아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
			// 잘못된 비밀번호
			if (!passwordEncoder.matches(userPassword, userEntity.getPassword())) {
				return ResponseDTO.setFailed("아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
		userEntity.setPassword("");

		String token = tokenProvider.create(username);
		int exprTime = 3600000;

		SignInResponseDTO signInResponseDTO = new SignInResponseDTO(token, exprTime, userEntity);
		return ResponseDTO.setSuccess("로그인 성공", signInResponseDTO);
	}

	// 유저 권한 승인 (0 일반유저 ->1 사서 )유저 권한 취소 (1 사서 -> 0 일반유저 ) 
	public ResponseDTO<?> updateUserPermission(String userId, Integer permission) {
		try {
			// 사용자 식별자(userId)를 기반으로 사용자를 데이터베이스에서 찾습니다.
			Optional<UserEntity> userOptional = userRepository.findById(userId);

			if (userOptional.isPresent()) {
				UserEntity user = userOptional.get();

				// permission 값을 업데이트합니다.
				user.setPermission(permission);

				// 변경된 사용자 정보를 데이터베이스에 저장합니다.
				userRepository.save(user);
				return ResponseDTO.setSuccess("권한 변경 성공", null);
			} else {
				return ResponseDTO.setFailed("사용자를 찾지 못했습니다."); // 사용자를 찾지 못한 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

}
