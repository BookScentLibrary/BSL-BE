package com.samsam.bsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .requestCache().disable()
      .cors().configurationSource(corsConfigurationSource()).and()
      .formLogin().disable()
      .httpBasic().disable()
      .csrf().disable();
    
    http
    .authorizeRequests()
    .antMatchers("/**")
    .permitAll()
    .anyRequest().authenticated();
    
    return http.build();
  }
	
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:3000");
<<<<<<< HEAD
=======
        corsConfiguration.addAllowedOrigin("http://121.173.199.79:3000");
>>>>>>> f4c3381928059d6679c8b9b7398f8bf962207c68
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader("Authorization");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
  
}
