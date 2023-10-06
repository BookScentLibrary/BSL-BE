package com.samsam.bsl.user.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.samsam.bsl.user.dto.SignUpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	public UserEntity(SignUpDTO dto) {
		super();
		this.userId = UUID.randomUUID().toString().replaceAll("-","");
		this.username = dto.getUsername();
		this.password = dto.getPassword();
		this.email = dto.getEmail();
		this.nickname = dto.getNickname();
		this.phone = dto.getPhone();
		this.gender = dto.getGender();
		this.userBirth = dto.getUserBirthAsLocalDate();
		this.userAge = calculateAge(dto.getUserBirthAsLocalDate());
		this.permission = 0;
	}
	//나이계산
	public int calculateAge(LocalDate userBirth) {
	    // 현재 날짜
	    LocalDate currentDate = LocalDate.now();

	    // 나이 계산
	    Period period = Period.between(userBirth, currentDate);

	    return period.getYears();
    }
}