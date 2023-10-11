package com.samsam.bsl.newbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/newbooks")
public class NewBooksController {

	private final NewBooksService newBooksService;

    public NewBooksController(NewBooksService newBooksService) {
        this.newBooksService = newBooksService;
    }

    @GetMapping("/new")
    public List<NewBooksDTO> getNewBooks() {
        return newBooksService.getNewBooks();
    }

}