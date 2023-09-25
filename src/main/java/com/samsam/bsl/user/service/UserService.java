package com.samsam.bsl.user.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.samsam.bsl.user.dao.UserDAO;
import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class UserService {

//	   @Autowired
//	    private UserRepository userRepository; // UserRepository는 사용자 정보를 저장하고 검색하는 데 사용됩니다.
//
//
////	    @Autowired
////	    private PasswordEncoder passwordEncoder; // 패스워드 암호화를 위한 PasswordEncoder
//	   
//	   
//	    
//	    // 회원가입 유효성 검사
//	    public void signupValidate(UserDTO userDTO) throws IllegalArgumentException {
//	        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
//	            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
//	        }
//
//	        if (userRepository.findByNickname(userDTO.getNickname()).isPresent()) {
//	            throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
//	        }
//	        //아이디 검증
//	        if(!Pattern.matches("^[a-zA-Z0-9]{8,20}$", userDTO.getUsername())){
//	            throw new IllegalArgumentException("아이디는 영문(대소문자)과 숫자로 8자에서 20자 사이여야 합니다.");
//	        }
//	        //비밀번호 검증
//	        if(!Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$", userDTO.getPassword())){
//	        	throw new IllegalArgumentException("비밀번호는 영문, 숫자, 특수문자(!, @, #, $, %, ^, &, *)로 8자에서 20자 사이여야 합니다.");
//	        }
//	        //이메일 검증
//	        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", userDTO.getEmail())){
//	            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
//	        }
//	        //닉네임 검증
//	        if(!Pattern.matches("^[가-힣]{3,8}$", userDTO.getNickname())){
//	            throw new IllegalArgumentException("닉네임은 한글 3자에서 8자 사이여야 합니다.");
//	        }
//	        //핸드폰 번호 검증
//	        if(!Pattern.matches("^[0-9]+$", userDTO.getPhone())) {
//	        	throw new IllegalArgumentException("숫자('-'빼고 01011112222)만 입력 가능합니다.");
//	        }
//	        //생년월일 검증
//	        if(!Pattern.matches("^\\d{8}$", userDTO.getUserBirth())) {
//	        	throw new IllegalArgumentException("생년월일은 (19990101)숫자 8자 형식으로 입력해주세요.");
//	        }
//	        //성별 검증
//	        if(!Pattern.matches("여|남", userDTO.getGender())) {
//	        	throw new IllegalArgumentException("성별을 선택해주세요.");
//	        }
//	    }
//
//	    //아이디 중복 체크
//	    public void usernameCheck(UserDTO userDTO) throws IllegalArgumentException {
//	        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
//	            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
//	        }
//	    }
//
//	    //닉네임 중복 체크
//	    public void nicknameCheck(UserDTO userDTO) throws IllegalArgumentException {
//	        if (userRepository.findByNickname(userDTO.getNickname()).isPresent()) {
//	            throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
//	        }
//	    }
	    
	    //로그인
} 
