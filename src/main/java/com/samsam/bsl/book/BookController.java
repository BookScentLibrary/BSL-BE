package com.samsam.bsl.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@GetMapping("/")
	public String testApi() {
		System.out.println("[testAPI]");
		return "이것은 스프링부트에서 보내는 메세지입니다 ^_^";
	}
}
