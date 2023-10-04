package com.samsam.bsl.user.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserDTO signup(UserDTO userDTO) throws IllegalArgumentException {
        String errorMessage = validateUser(userDTO);

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
    }

    // 회원가입 유효성 검사 (아이디, 비밀번호, 이메일, 닉네임, 핸드폰 번호, 생년월일, 성별에 대한 유효성 검사)
    private String validateUser(UserDTO userDTO) {
        // 아이디 중복 체크
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            return "중복된 아이디가 존재합니다.";
        }
        // 닉네임 중복 체크
        if (userRepository.findByNickname(userDTO.getNickname()).isPresent()) {
            return "중복된 닉네임이 존재합니다.";
        }
        // 아이디 검증
        if (!isValidField(userDTO.getUsername(), "^[a-zA-Z0-9]{8,20}$")) {
            return "아이디는 영문(대소문자)과 숫자로 8자에서 20자 사이여야 합니다.";
        }
        // 비밀번호 검증
        if (!isValidField(userDTO.getPassword(), "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$")) {
            return "비밀번호는 영문, 숫자, 특수문자(!, @, #, $, %, ^, &, *)로 8자에서 20자 사이여야 합니다.";
        }
        // 이메일 검증
        if (!isValidField(userDTO.getEmail(), "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            return "이메일 형식이 올바르지 않습니다.";
        }
        // 닉네임 검증
        if (!isValidField(userDTO.getNickname(), "^[가-힣]{3,8}$")) {
            return "닉네임은 한글 3자에서 8자 사이여야 합니다.";
        }
        // 핸드폰 번호 검증
        if (!isValidField(userDTO.getPhone(), "^[0-9]+$")) {
            return "숫자('-'빼고 01011112222)만 입력 가능합니다.";
        }
        // 생년월일 검증
        if (!isValidField(userDTO.getUserBirth(), "^\\d{8}$")) {
            return "생년월일은 (19990101)숫자 8자 형식으로 입력해주세요.";
        }
        // 성별 검증
        if (!isValidField(userDTO.getGender(), "여|남")) {
            return "성별을 선택해주세요.";
        }
        
        // 모든 검사를 통과한 경우 null(오류 없음) 반환
        return null;
    }

    // 필드 값의 유효성을 검사하는 메서드
    private boolean isValidField(String field, String pattern) {
        return Pattern.matches(pattern, field);
    }

} 
