package com.samsam.bsl.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findById(String userId);
    Optional<UserEntity> findByNickname(String nickname);
    
    //userId로 user찾기
    public UserEntity findByUserId(String userId);
    
    // 아이디 중복 검사
    boolean existsByUsername(String username);

    // 닉네임 중복 검사
    boolean existsByNickname(String nickname);
    
    //로그인
    public UserEntity findByUsername(String username);
}
