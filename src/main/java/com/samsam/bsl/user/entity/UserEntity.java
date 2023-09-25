package com.samsam.bsl.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.samsam.bsl.user.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
	
	@Id
	private String userId; //userUUID
	
	@Column(length = 40, unique = true, nullable = false)
	private String username;//사용자ID
	
	@Column(length = 20, nullable = false)
	private String password;//비밀번호
	
	@Column(length = 20, nullable = false)
	private String email;//이메일
	
	@Column(length = 20, unique = true, nullable = false)
	private String nickname;//닉네임
	
	@Column(length = 20, nullable = false)
	private String phone;//연락처 010-0000-0000
	
	@Column(length = 10, nullable = false)
	private String gender;//성별 여/남
	
	@Column(nullable = false)
	private String userBirth;//생년월일 (yyyyMMdd, 예: 20000101)
	
	@Column(nullable = false)
	private int userAge;//나이 12
	
	@Column(nullable = false)
	private int permission;//권한 0 : 일반 유저/1 : 사서/ 2 : 관리자
	
	private static UserEntity toSaveEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userDTO.getUserId());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setNickname(userDTO.getNickname());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setGender(userDTO.getGender());
		userEntity.setUserBirth(userDTO.getUserBirth());
		userEntity.setUserAge(userDTO.getUserAge());
		userEntity.setPermission(userDTO.getPermission());
		return userEntity;
	}
}
