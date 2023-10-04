package com.samsam.bsl.book.service;

import com.samsam.bsl.book.dao.BookDetailDAO;
import com.samsam.bsl.book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookDetailDAO bookDetailDAO;

    public BookDTO getBook() {
        return null;
    }
}
