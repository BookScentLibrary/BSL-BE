package com.samsam.bsl.user.dto;

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
	public UserDTO(String userId, String username, String password, String email, String nickname, String phone,
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
		this.permission = 0;
	}
	
	//getter/setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
}
