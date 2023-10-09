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
	UserInfoValidator userInfoValidator;
	@Autowired
	TokenProvider tokenProvider;

	private final PasswordEncoder passwordEncoder;
	
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	//회원가입
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
	//로그인
	public ResponseDTO<SignInResponseDTO> signIn(SignInDTO dto) {
		System.out.println("[UserService] signIn()");
		String username = dto.getUsername();
		String userPassword = dto.getPassword();

		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findByUsername(username);
			System.out.println("[UserService] signIn() username : "+username);
			//아이디 못 찾을때
			if(userEntity == null) {
				System.out.println("[UserService] signIn() null 아이디 못 찾음.");
				return ResponseDTO.setFailed("아이디 못 찾음. 아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
			//잘못된 비밀번호
			if(!passwordEncoder.matches(userPassword, userEntity.getPassword())) {
				System.out.println("[UserService] signIn() 입력한 비밀번호 : "+ passwordEncoder.encode(userPassword) );
				System.out.println("[UserService] signIn() 가져온 비밀번호 : "+ userEntity.getPassword() );
				System.out.println("[UserService] signIn() 비밀번호 다름.");
				return ResponseDTO.setFailed("비밀번호 다름. 아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[UserService] signIn() 데이터베이스 오류입니다.");
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
		userEntity.setPassword("");

		String token = tokenProvider.create(username);
		System.out.println("[UserService] signIn() token만들었다 : " + token);
		int exprTime = 3600000;

		SignInResponseDTO signInResponseDTO = new SignInResponseDTO(token, exprTime, userEntity);
		System.out.println("[UserService] signIn() token반환가능하다 : " + token);
		System.out.println("[UserService] signIn() exprTime 반환: " + exprTime);
		System.out.println("[UserService] signIn() userEntity 반환: " + userEntity.toString());
		return ResponseDTO.setSuccess("로그인 성공", signInResponseDTO);
	}

}
