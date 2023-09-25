package com.samsam.bsl.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping({"", "/"})
	public @ResponseBody String index() {
		return "index";
	}
	//회원 가입 페이지
	@GetMapping("/signUp")
	public String signUp(UsersVO usersVO) {
		System.out.println(usersVO);
		usersVO.setPermission(0);
		String rawPassword = usersVO.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		usersVO.setPassword(encPassword);
		//회원가입 내용 저장할 공간넣기
		return "redirect:/loginFrom";
	}
}
