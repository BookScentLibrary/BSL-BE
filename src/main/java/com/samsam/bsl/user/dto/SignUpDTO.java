package com.samsam.bsl.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
	@NotBlank
	private String username;//사용자ID
	@NotBlank
	private String password;//비밀번호
	@NotBlank
	private String passwordAgain;//비밀번호 확인
	@NotBlank
	private String email;//이메일
	@NotBlank
	private String nickname;//닉네임
	@NotBlank
	private String phone;//연락처
	@NotBlank
	private String gender;//성별
	@NotBlank
	private String userBirth;//생년월일



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
