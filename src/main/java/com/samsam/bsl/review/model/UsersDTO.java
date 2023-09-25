package com.samsam.bsl.review.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UsersDTO {
	private String userId; // userUUID
	private String username;// 사용자ID
	private String password;// 비밀번호
	private String email;// 이메일
	private String nickname;// 닉네임
	private String phone;// 연락처 010-0000-0000
	private String gender;// 성별 여/남
	private String userBirth;// 생년월일 (yyyyMMdd, 예: 20000101)
	private int userAge;// 나이 12
	private int permission;// 권한 0 : 일반 유저/1 : 사서/ 2 : 관리자

	@Builder
	public UsersDTO(String userId, String username, String password, String email, String nickname, String phone,
			String gender, String userBirth, int userAge, int permission) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.gender = gender;
		this.userBirth = userBirth;
		this.userAge = userAge;
		this.permission = permission;
	}
}