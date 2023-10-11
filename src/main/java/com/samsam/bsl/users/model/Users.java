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
	@Column(name = "userid")
	private String userId;
	
	private String username;
	private String password;
	private String email;
	private String nickname;
	private String phone;
	private String gender;
	
	@Column(name = "userbirth")
	private LocalDateTime userBirth;
	
	@Column(name = "userage")
	private int userAge;
	
	private int permission;
}