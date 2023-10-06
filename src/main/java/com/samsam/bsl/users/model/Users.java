package com.samsam.bsl.users.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private LocalDateTime userBirth;
	
	@Column(nullable = false)
	private int userAge;
	
	@Column(nullable = false)
	private int permission;
}