package com.samsam.bsl.user.dto;

import com.samsam.bsl.user.entity.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	private String username;//사용자ID
	private String password;//비밀번호
	private String email;//이메일
	private String nickname;//닉네임
	private String phone;//연락처 010-0000-0000
	private String gender;//성별 여/남
	private String userBirth;//생년월일 (yyyyMMdd, 예: 20000101)



	// UserEntity를 UserDTO로 변환하는 메서드
//	public static UserDTO toUserDTO(UserEntity userEntity) {
//		UserDTO userDTO = new UserDTO(userEntity.getUsername(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getNickname(), userEntity.getPhone(), userEntity.getGender(), userEntity.getUserBirth().toString(), userEntity.getUserAge());
//		return userDTO;
//	}

    // UserEntity를 UserDTO로 변환하는 메서드
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
