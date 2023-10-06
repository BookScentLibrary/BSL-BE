package com.samsam.bsl.user.dto;

import com.samsam.bsl.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDTO {
	private String token;
	private int exprTime;
	private UserEntity user;
}
