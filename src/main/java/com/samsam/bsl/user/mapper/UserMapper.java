package com.samsam.bsl.user.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.samsam.bsl.user.dto.UserDTO;
import com.samsam.bsl.user.entity.UserEntity;

@Component
public class UserMapper {
    public UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setNickname(entity.getNickname());
        dto.setPhone(entity.getPhone());
        dto.setGender(entity.getGender());
        dto.setUserBirth(entity.getUserBirth().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        dto.setUserAge(String.valueOf(entity.getUserAge()));
        return dto;
    }

    public UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity(dto.getUsername(), dto.getPassword(), dto.getEmail(), dto.getNickname(), dto.getPhone(),
                dto.getGender(), LocalDate.parse(dto.getUserBirth(), DateTimeFormatter.ofPattern("yyyyMMdd")), Integer.parseInt(dto.getUserAge()));
        return entity;
    }
}
