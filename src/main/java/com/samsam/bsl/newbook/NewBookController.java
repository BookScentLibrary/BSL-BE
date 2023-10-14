//package com.samsam.bsl.newbook;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
//@RestController
//@RequestMapping("/newbook")
//@Transactional
//public class NewBookController {
//
//	@Autowired
//	private NewBookService newBookService;
//
//    public NewBookController(NewBookService newBookService) {
//        this.newBookService = newBookService;
//    }
//
//    @GetMapping("/list")
//    public List<NewBook> getNewBooks() {
//        return newBookService.getNewBooksRanking();
//    }
//
//}