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

	// 회원가입 메서드
	/*
	 * public UserDTO signup(UserDTO userDTO) throws IllegalArgumentException {
	 * String errorMessage = userInfoValidator(userDTO);
	 * 
	 * // 오류 메시지가 비어있지 않다면 예외를 던짐 if (errorMessage != null) { throw new
	 * IllegalArgumentException(errorMessage); }
	 * 
	 * // 패스워드 암호화 String encodedPassword =
	 * passwordEncoder.encode(userDTO.getPassword());
	 * userDTO.setPassword(encodedPassword);
	 * 
	 * // UserDTO를 UserEntity로 변환 UserEntity userEntity =
	 * UserEntity.toSaveEntity(userDTO);
	 * 
	 * // UserRepository를 사용하여 사용자 정보 저장 UserEntity savedUserEntity =
	 * userRepository.save(userEntity);
	 * 
	 * // 저장된 UserEntity를 UserDTO로 변환하여 반환 return
	 * UserDTO.toUserDTO(savedUserEntity); }
	 */

	// 회원가입 요청
//    public ResponseDTO signUp(SignUpDTO userDTO) {
//
//    	ResponseDTO responseDTO = null;
//
//        String username = userDTO.getUsername();
//
//        // 비밀번호 암호화
//        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
//        System.out.println(encodedPassword);
//    	String email = userDTO.getEmail();
//    	String nickname = userDTO.getNickname();
//    	String phone = userDTO.getPhone();
//    	String gender = userDTO.getGender();
//    	String userBirth = userDTO.getUserBirth();
//
//        // 회원 정보 저장
//        UserEntity user = new UserEntity(username, encodedPassword, email, nickname, phone,
//    			gender, userBirth);
//        userRepository.save(user);
//        responseDTO = new ResponseDTO(true);
//        System.out.println("회원가입성공");
//        System.out.println(user.getPassword());
//        System.out.println(user.getUserId());
//
//        return responseDTO;
//    }

	public ResponseDTO<?> signUp(SignUpDTO dto) {
		// 유효성 검사
		if (userInfoValidator.getValidMessage(dto).isResult()) {
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
