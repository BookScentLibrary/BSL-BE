package com.samsam.bsl.newbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewBookService {
	
    @Autowired
    NewBookRepository newBookRepository;

    public List<NewBookDTO> getNewBooks() {
        return newBookRepository.getNewBooks();
    }
    
}