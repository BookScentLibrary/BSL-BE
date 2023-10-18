package com.samsam.bsl.bestseller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.rent.domain.Book;

@Service
public class BestService {
	@Autowired
	BestRepository bestRepository;

	public List<Best> getBest() {
		
		return bestRepository.findAllByOrderByRankAsc();
	}
}
