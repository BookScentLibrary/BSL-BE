package com.samsam.bsl.bestseller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.rent.domain.Book;

@RestController
@RequestMapping("/book/bestseller")
public class BestController {

	@Autowired
	BestService bestService;

	@GetMapping("")
	public @ResponseBody List<Best> getBestSeller() {
		try {
			System.out.println(bestService.getBest());
			List<Best> list = bestService.getBest();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
