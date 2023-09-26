package com.samsam.bsl.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserDTO> findByUsername(String username);
    Optional<UserDTO> findByNickname(String nickname);


}
