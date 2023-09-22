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
<<<<<<< HEAD

		BookTestDTO dto = new BookTestDTO();
		dto.setBookNo(00000001);
		dto.setBookImageURL("https://image.aladin.co.kr/product/19359/16/cover/s972635417_1.jpg");
		dto.setBookname("ï¿½ì¸®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Óµï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½Ù¸ï¿½");
		dto.setAuthor("ï¿½ï¿½ï¿½Ê¿ï¿½");
		dto.setPublisher("ï¿½ï¿½ï¿½");
		dto.setPublicationYear("2019");
		dto.setCallNum("813.7");
		dto.setShelfarea("[ï¿½ï¿½ï¿½ï¿½]Å«ï¿½ï¿½ï¿½Úµï¿½ï¿½ï¿½");
		dto.setClassname("ï¿½ï¿½ï¿½ï¿½ > ï¿½Ñ±ï¿½ï¿½ï¿½ï¿½ï¿½ > ï¿½Ò¼ï¿½");
		dto.setBookStatus(0);
		dto.setRentCnt(10);
		dto.setIsbn("9791190090018");
		dto.setDescription("2017ï¿½ï¿½ 'ï¿½ï¿½ï¿½ï¿½ï¿½Ð½ï¿½'ï¿½ï¿½ 'ï¿½ì¸®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Óµï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½Ù¸ï¿½'ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½2È¸ ï¿½Ñ±ï¿½ï¿½ï¿½ï¿½Ð¹ï¿½ï¿½Ð»ï¿½ ï¿½ß´ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï¸ï¿½ ï¿½ï¿½Ç° È°ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ê¿ï¿½ ï¿½ï¿½Ç°ï¿½ï¿½. 'ï¿½ï¿½ï¿½ï¿½ï¿½Úµï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½Æ¿ï¿½ï¿½ï¿½ ï¿½Ê´Â°ï¿½', 'ï¿½ï¿½ï¿½ï¿½Æ®ï¿½ï¿½', 'ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½', 'ï¿½ì¸®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Óµï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½Ù¸ï¿½', 'ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½', 'ï¿½ï¿½ï¿½ï¿½ï¿½Ð½ï¿½', 'ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ï¿ï¿½'ï¿½ï¿½ ï¿½ï¿½ï¿½ÏµÇ¾ï¿½ï¿½ï¿½.");
		return dto;
		
=======
		return "ÀÌ°ÍÀº ½ºÇÁ¸µºÎÆ®¿¡¼­ º¸³»´Â ¸Þ¼¼ÁöÀÔ´Ï´Ù ^_^";
>>>>>>> parent of fd77842 (feat #3: json response test)
	}
}
