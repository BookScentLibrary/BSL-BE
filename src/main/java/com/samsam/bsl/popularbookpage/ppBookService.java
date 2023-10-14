package com.samsam.bsl.popularbookpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.rent.domain.Book;

@Service
public class ppBookService {


    @Autowired
    private ppBookPageRepository ppbookRepository;

    public Page<Book> getppBook() {

//	return ppbookRepository.ppBookDesc();
        return null;
    }
}
