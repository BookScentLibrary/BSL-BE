package com.samsam.bsl.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.users.service.UserService;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
    private UserService userService;
}