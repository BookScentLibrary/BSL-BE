package com.samsam.bsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class BslApplication {

	public static void main(String[] args) {
		SpringApplication.run(BslApplication.class, args);
		
	}

}