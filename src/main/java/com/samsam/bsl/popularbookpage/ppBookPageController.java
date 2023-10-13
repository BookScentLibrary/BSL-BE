package com.samsam.bsl.popularbookpage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsam.bsl.book.rent.domain.Book;

@Controller
public class ppBookPageController {

	@Autowired
    private ppBookPageService bookService;
	
	@GetMapping("/ppBooks")
	@ResponseBody
	public Page<Book> findTop20ByOrderByRentCntDesc(Pageable pageable){
		return bookService.findTop20ByOrderByRentCntDesc(pageable);
	}
	
	
}
	
	

	
//	@Autowired
//    private ppBookService bookService;


//    @GetMapping
//    public ResponseEntity<List<Book>> getPopularBooks() {
//        Page<Book> popularBooks = bookService.getppBook();
//        return new ResponseEntity<>(popularBooks, HttpStatus.OK);

//    }

	
	
//	@GetMapping("/popularBookPage")
//	@ResponseBody
//	public String main() {
//		
//		return "Hello World";
//	}

	
//}

