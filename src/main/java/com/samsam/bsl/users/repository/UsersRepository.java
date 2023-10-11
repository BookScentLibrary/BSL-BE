package com.samsam.bsl.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.users.model.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

}