package com.samsam.bsl.newbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/newbooks")
@Transactional
public class NewBooksController {

	@Autowired
	private NewBooksService newBooksService;

    public NewBooksController(NewBooksService newBooksService) {
        this.newBooksService = newBooksService;
    }

    @GetMapping("/new")
    public List<NewBooksDTO> newBooksRanking() {
        return newBooksService.getNewBooks();
    }

}