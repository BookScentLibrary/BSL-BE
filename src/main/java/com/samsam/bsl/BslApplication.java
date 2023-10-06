package com.samsam.bsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class BslApplication {

	public static void main(String[] args) {
		SpringApplication.run(BslApplication.class, args);
		
	}

}