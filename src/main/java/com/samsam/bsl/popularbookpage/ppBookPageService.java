//package com.samsam.bsl.popularbookpage;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//
//import com.samsam.bsl.book.rent.domain.Book;
//
//@Service
//public class ppBookPageService {
//
//
//	@Autowired
//	private ppBookPageRepository ppbookPageRepository;
//
//
//	public List<Book> findByrentCntOrderByRentCntDesc() {
//
//		Sort sort = Sort.by(Sort.Order.desc("rentCnt"));
//
//		 return  ppbookPageRepository.findByrentCntOrderByRentCntDesc();
//
//	}
//}
