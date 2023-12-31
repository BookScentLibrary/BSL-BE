package com.samsam.bsl.book.search.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import static com.samsam.bsl.book.rent.domain.QBook.book;

public class SearchRepositoryImp implements SearchRepositoryQueryDsl {

	  private final JPAQueryFactory queryFactory;

  
	    public SearchRepositoryImp(JPAQueryFactory queryFactory) {
	        this.queryFactory = queryFactory;
	    }
	
	@Override
	public Book getBookname(String bookname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	EntityManager em;

	@Override
	public Page<Book> findBybooknameContaining(String searchValue, Pageable pageable) {
	

		@SuppressWarnings("deprecation")
		QueryResults<Book> results = queryFactory

				.select(Projections.constructor(
                        Book.class,
                        book.bookNo,
                        book.bookImageURL,
                        book.bookname,
                        book.author,
                        book.publisher,
                        book.publicationYear,
                        book.callNum,
                        book.shelfArea,
                        book.format,
                        book.className,
                        book.bookStatus,
                        book.rentCnt,
                        book.isbn,
                        book.description,
                        book.regDate
                ))
                .from(book)
                .where(book.bookname.contains(searchValue))
                .fetchResults();
		List<Book> content = results.getResults();
		Long total = results.getTotal();
		return new PageImpl<>(content, pageable, total);
	}


	

	public Page<Book> findByauthorContaining (String searchValue, Pageable pageable){

		
		@SuppressWarnings("deprecation")
		QueryResults<Book> results = queryFactory
				.select(Projections.constructor(
                        Book.class,
                        book.bookNo,
                        book.bookImageURL,
                        book.bookname,
                        book.author,
                        book.publisher,
                        book.publicationYear,
                        book.callNum,
                        book.shelfArea,
                        book.format,
                        book.className,
                        book.bookStatus,
                        book.rentCnt,
                        book.isbn,
                        book.description,
                        book.regDate
                ))
                .from(book)
                .where(book.author.contains(searchValue))
                .fetchResults();
		List<Book> content = results.getResults();
		Long total = results.getTotal();
						return new PageImpl<>(content, pageable, total);
		

		
	}
	
	public Page<Book> findBypublisherContaining (String searchValue, Pageable pageable){

		
		@SuppressWarnings("deprecation")
		QueryResults<Book> results = queryFactory
				.select(Projections.constructor(
                        Book.class,
                        book.bookNo,
                        book.bookImageURL,
                        book.bookname,
                        book.author,
                        book.publisher,
                        book.publicationYear,
                        book.callNum,
                        book.shelfArea,
                        book.format,
                        book.className,
                        book.bookStatus,
                        book.rentCnt,
                        book.isbn,
                        book.description,
                        book.regDate
                ))
                .from(book)
                .where(book.publisher.contains(searchValue))
                .fetchResults();
		List<Book> content = results.getResults();
		Long total = results.getTotal();

						return new PageImpl<>(content, pageable, total);
	
	
	}
	
	
	
	
}
