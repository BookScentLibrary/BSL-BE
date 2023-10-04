package com.samsam.bsl.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@GetMapping("/")
	public @ResponseBody BookDTO testApi() {
		BookDTO dto = new BookDTO();

		dto.setBookNo(00000001);
		dto.setBookImageURL("https://image.aladin.co.kr/product/19359/16/cover/s972635417_1.jpg");
		dto.setBookname("우리가 빛의 속도로 갈 수 없다면");
		dto.setAuthor("김초엽");
		dto.setPublisher("허블");
		dto.setPublicationYear("2019");
		dto.setCallNum("813.7");
		dto.setShelfarea("[논현]큰글자도서");
		dto.setFormat("어떻게생겼나...");
		dto.setClassName("문학 > 한국문학 > 소설");
		dto.setBookStatus(0);
		dto.setRentCnt(10);
		dto.setIsbn("9791190090018");
		dto.setDescription("2017년 '관내분실'과 '우리가 빛의 속도로 갈 수 없다면'으로 제2회 한국과학문학상 중단편 대상과 가작을 수상하며 작품 활동을 시작한 김초엽 작품집. '순례자들은 왜 돌아오지 않는가', '스펙트럼', '공생가설', '우리가 빛의 속도로 갈 수 없다면', '감정의 물성', '관내분실', '나의 우주 영웅에 관하여'가 수록되었다.");
		return dto;
	}
}
