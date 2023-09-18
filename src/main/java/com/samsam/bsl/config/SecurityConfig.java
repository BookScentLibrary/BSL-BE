package com.samsam.bsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .requestCache().disable()
      .formLogin().disable()
      .httpBasic().disable()
      .csrf().disable();

    return http.build();
  }
  
  //비밀번호 암호화
  @Bean
  public BCryptPasswordEncoder encodePwd() {
	  return new BCryptPasswordEncoder();
  }
}
