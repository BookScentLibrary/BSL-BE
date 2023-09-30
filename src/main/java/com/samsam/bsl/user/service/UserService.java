package com.samsam.bsl.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입 메서드
 /*   public UserDTO signup(UserDTO userDTO) throws IllegalArgumentException {
        String errorMessage = userInfoValidator(userDTO);

        // 오류 메시지가 비어있지 않다면 예외를 던짐
        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage);
        }

        // 패스워드 암호화
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);

        // UserDTO를 UserEntity로 변환
        UserEntity userEntity = UserEntity.toSaveEntity(userDTO);

        // UserRepository를 사용하여 사용자 정보 저장
        UserEntity savedUserEntity = userRepository.save(userEntity);

        // 저장된 UserEntity를 UserDTO로 변환하여 반환
        return UserDTO.toUserDTO(savedUserEntity);
    }*/
    
    // 회원가입 요청
    public ResponseDTO signup(UserDTO userDTO) {

    	ResponseDTO responseDTO = null;

        String username = userDTO.getUsername();

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        System.out.println(encodedPassword);
    	String email = userDTO.getEmail();
    	String nickname = userDTO.getNickname();
    	String phone = userDTO.getPhone();
    	String gender = userDTO.getGender();
    	String userBirth = userDTO.getUserBirth();

        // 회원 정보 저장
        UserEntity user = new UserEntity(username, encodedPassword, email, nickname, phone,
    			gender, userBirth);
        userRepository.save(user);
        responseDTO = new ResponseDTO(true);
        System.out.println("회원가입성공");
        System.out.println(user.getPassword());
        System.out.println(user.getUserId());

        return responseDTO;
    }

} 
