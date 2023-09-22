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
		return "살려조요 개발에서 날 꺼내조요 콤퓨타에 가쳤어요!";
	}
}
