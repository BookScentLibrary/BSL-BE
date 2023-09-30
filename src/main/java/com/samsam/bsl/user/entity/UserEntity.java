package com.samsam.bsl.user.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    private String userId; //userUUID

    @Column(length = 40, unique = true, nullable = false)
    private String username;//사용자ID

    @Column(length = 80, nullable = false)
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
    private LocalDate userBirth; // 수정: LocalDateTime로 변경

    @Column(nullable = false)
    private int userAge; //나이 12

    @Column(nullable = false)
    private int permission; //권한 0 : 일반 유저/1 : 사서/ 2 : 관리자
	
	//생성자
	public UserEntity(String username, String password, String email, String nickname, String phone,
			String gender, String userBirth) {
		super();
		this.userId = UUID.randomUUID().toString().replaceAll("-","");
		this.username = username;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.gender = gender;
		this.userBirth = LocalDate.parse(userBirth);
		this.userAge = calculateAge(userBirth);
		this.permission = 0;
	}
	//나이계산
	public int calculateAge(String userBirth) {
	    // 현재 날짜
	    LocalDate currentDate = LocalDate.now();

	    // 하이픈 제거 후 생년월일을 LocalDate로 변환
	    LocalDate birthDateObj = LocalDate.parse(userBirth.replace("-", ""), DateTimeFormatter.ofPattern("yyyyMMdd"));

	    // 나이 계산
	    Period period = Period.between(birthDateObj, currentDate);

	    return period.getYears();
    }
	
	//생성자로 UserDTO를 UserEntity로 변환하기
//    public UserEntity(UserDTO userDTO) {
//        this.userId = userDTO.getUserId();
//        this.username = userDTO.getUsername();
//        this.password = userDTO.getPassword();
//        this.email = userDTO.getEmail();
//        this.nickname = userDTO.getNickname();
//        this.phone = userDTO.getPhone();
//        this.gender = userDTO.getGender();
//        this.userBirth = LocalDateTime.parse(userDTO.getUserBirth(), DateTimeFormatter.ofPattern("yyyyMMdd"));
//        this.userAge = userDTO.getUserAge();
//        this.permission = userDTO.getPermission();
//    }
	
    //UserDTO를 UserEntity로 변환하기
	/*public static UserEntity toSaveEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userDTO.getUserId());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setNickname(userDTO.getNickname());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setGender(userDTO.getGender());
		userEntity.setUserBirth(LocalDateTime.parse(userDTO.getUserBirth(), DateTimeFormatter.ofPattern("yyyyMMdd")));
		userEntity.setUserAge(Integer.parseInt(userDTO.getUserAge()));
		userEntity.setPermission(userDTO.getPermission());
		return userEntity;
	}*/
}