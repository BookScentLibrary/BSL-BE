package com.samsam.bsl.book.rent.service;

import com.samsam.bsl.book.rent.dto.BookDTO;
import com.samsam.bsl.book.rent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository bookRepository;

  @Override
  public BookDTO getBook(int bookNo) {
    return bookRepository.getBook(bookNo);
  }
}
