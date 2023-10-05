package com.samsam.bsl.user.service;

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
	PasswordEncoder passwordEncoder;
	@Autowired
	UserInfoValidator userInfoValidator;
	@Autowired
	TokenProvider tokenProvider;

	public ResponseDTO<?> signUp(SignUpDTO dto) {
		// 유효성 검사
		if (userInfoValidator.getValidMessage(dto).isResult()) {
			//비밀번호 암호화
			String encodedPassword = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(encodedPassword);
	        
			// UserEntity 생성
			UserEntity userEntity = new UserEntity(dto);
			try {
				// UserRepository를 이용해서 데이터베이스에 Entity 저장
				userRepository.save(userEntity);
			} catch (Exception e) {
				return ResponseDTO.setFailed("데이터베이스 오류입니다.");
			}
		}
		// 성공시 success response반환
		return ResponseDTO.setSuccess("회원가입 성공", null);
	}

	public ResponseDTO<SignInResponseDTO> signIn(SignInDTO dto) {
		String username = dto.getUsername();
		String userPassword = dto.getPassword();
		String password = passwordEncoder.encode(userPassword);
		dto.setPassword(password);
		try {
			boolean existed = userRepository.existsByUsernameAndPassword(username, password);

			if (!existed) {
				return ResponseDTO.setFailed("로그인 정보가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findByUsername(username).get();
		} catch (Exception e) {
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
		userEntity.setPassword("");

		String token = tokenProvider.create(username);
		int exprTime = 3600000;

		SignInResponseDTO signInResponseDTO = new SignInResponseDTO(token, exprTime, userEntity);
		return ResponseDTO.setSuccess("로그인 성공", signInResponseDTO);
	}

}
