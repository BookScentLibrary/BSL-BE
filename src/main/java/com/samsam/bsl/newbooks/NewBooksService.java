package com.samsam.bsl.newbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewBooksService {
	
    private final NewBooksRepository newBooksRepository;

    @Autowired
    public NewBooksService(NewBooksRepository newBooksRepository) {
        this.newBooksRepository = newBooksRepository;
    }

    public List<NewBooksDTO> getNewBooks() {
        return newBooksRepository.newBooksRanking();
    }
    
}