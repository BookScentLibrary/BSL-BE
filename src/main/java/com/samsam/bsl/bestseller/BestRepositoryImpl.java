package com.samsam.bsl.bestseller;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.bestseller.QBest.best;

public class BestRepositoryImpl implements BestRepositoryQueryDsl{
	private final JPAQueryFactory queryFactory;

	  static final int SUCCESS = 1;
	  static final int FAIL = 0;

	  public BestRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	  }

	
	
	@Override
	public List<Book> getBestseller() {
		List<Book> result = queryFactory
				.selectFrom(book)
				.orderBy(book.rentCnt.desc())
				.limit(20)
				.fetch();
		return result;
	}
	
//	public List<Best> getBest() {
//		List<Best> result = queryFactory
//				.selectFrom(best)
//				.where(best.bookNo)
//			
//	}
}
