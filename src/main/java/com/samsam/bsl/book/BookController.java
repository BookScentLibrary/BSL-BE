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
		dto.setBookname("�츮�� ���� �ӵ��� �� �� ���ٸ�");
		dto.setAuthor("���ʿ�");
		dto.setPublisher("���");
		dto.setPublicationYear("2019");
		dto.setCallNum("813.7");
		dto.setShelfarea("[����]ū���ڵ���");
		dto.setClassname("���� > �ѱ����� > �Ҽ�");
		dto.setBookStatus(0);
		dto.setRentCnt(10);
		dto.setIsbn("9791190090018");
		dto.setDescription("2017�� '�����н�'�� '�츮�� ���� �ӵ��� �� �� ���ٸ�'���� ��2ȸ �ѱ����й��л� �ߴ��� ���� ������ �����ϸ� ��ǰ Ȱ���� ������ ���ʿ� ��ǰ��. '�����ڵ��� �� ���ƿ��� �ʴ°�', '����Ʈ��', '��������', '�츮�� ���� �ӵ��� �� �� ���ٸ�', '������ ����', '�����н�', '���� ���� ������ ���Ͽ�'�� ���ϵǾ���.");
		return dto;
		
=======
		return "�̰��� ��������Ʈ���� ������ �޼����Դϴ� ^_^";
>>>>>>> parent of fd77842 (feat #3: json response test)
	}
}
