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
<<<<<<< HEAD
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
=======
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
	
>>>>>>> efbbb2dc41d612ebcf02856ea351befab5cdbb3f
	private int permission;
}