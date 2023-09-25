package com.samsam.bsl.user.dto;

import java.util.UUID;

import com.samsam.bsl.user.entity.UserEntity;

import lombok.Data;

@Data
public class UserDTO {
	private String userId; //userUUID
	private String username;//사용자ID
	private String password;//비밀번호
	private String email;//이메일
	private String nickname;//닉네임
	private String phone;//연락처 010-0000-0000
	private String gender;//성별 여/남
	private String userBirth;//생년월일 (yyyyMMdd, 예: 20000101)
	private int userAge;//나이 12
	private int permission;//권한 0 : 일반 유저/1 : 사서/ 2 : 관리자
	
	//생성자
	public UserDTO(String username, String password, String email, String nickname, String phone,
			String gender, String userBirth, int userAge) {
		super();
		this.userId = UUID.randomUUID().toString().replaceAll("-","");
		this.username = username;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.gender = gender;
		this.userBirth = userBirth;
		this.userAge = userAge;
		this.permission = 0;
	}
	
	// UserEntity를 UserDTO로 변환하는 메서드
	public static UserDTO toUserDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO(userEntity.getUsername(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getNickname(), userEntity.getPhone(), userEntity.getGender(), userEntity.getUserBirth().toString(), userEntity.getUserAge());
		return userDTO;
	}
	
//    // UserEntity를 UserDTO로 변환하는 메서드
//    public static UserDTO toUserDTO(UserEntity userEntity) {
//        UserDTO userDTO = new UserDTO(
//            userEntity.getUsername(),
//            userEntity.getPassword(),
//            userEntity.getEmail(),
//            userEntity.getNickname(),
//            userEntity.getPhone(),
//            userEntity.getGender(),
//            userEntity.getUserBirth().toString(),
//            userEntity.getUserAge()
//        );
//        return userDTO;
//    }
}
