package com.samsam.bsl.user.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
	
	//String -> LocalDate타입으로 변환
    public LocalDate getUserBirthAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            LocalDate date = LocalDate.parse(this.userBirth, formatter);
            return date;
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
