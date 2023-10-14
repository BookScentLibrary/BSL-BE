package com.samsam.bsl.newbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewBookService {
	
//    private final NewBookRepository newBookRepository;

//    @Autowired
//    public NewBookService(NewBookRepository newBookRepository) {
//        this.newBookRepository = newBookRepository;
//    }

    @Autowired
    NewBookRepository newBookRepository;

//    public List<NewBook> getNewBooksRanking() {
//        return newBookRepository.newBooksRanking();
//    }

    public List<NewBookDTO> getNewBooks() {
        return newBookRepository.getNewBooks();
    }
}
