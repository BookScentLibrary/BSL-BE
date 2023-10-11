package com.samsam.bsl.newbooks;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewBooksService {
	
    private final NewBooksRepository newBooksRepository;

    public NewBooksService(NewBooksRepository newBooksRepository) {
        this.newBooksRepository = newBooksRepository;
    }

    public List<NewBooksDTO> getNewBooks() {
        return newBooksRepository.newBooksRanking();
    }
    
}