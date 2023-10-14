//package com.samsam.bsl.popularbookpage;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//
//import com.querydsl.core.QueryResults;
//import com.querydsl.core.types.Projections;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.samsam.bsl.book.rent.domain.Book;
//import static com.samsam.bsl.book.rent.domain.QBook.book;
//
//
//
//import java.util.List;
//
//public class ppBookRepositoryImp implements ppBookPageRepositoryQueryDsl {
//
//	private final JPAQueryFactory queryFactory;
//
//	public ppBookRepositoryImp(JPAQueryFactory queryFactory) {
//		this.queryFactory = queryFactory;
//	}
//
//	@Autowired
//	EntityManager em;
//
//
//	@Override
//	public List<Book> findByrentCntOrderByRentCntDesc() {
//		System.out.println("파인드 인기 도서 ");
//
//		@SuppressWarnings("deprecation")
//		QueryResults<Book> ppBookresults = queryFactory
//				.select(Projections.constructor(
//                        Book.class,
//                        book.bookNo,
//                        book.bookImageURL,
//                        book.bookname,
//                        book.author,
//                        book.publisher,
//                        book.publicationYear,
//                        book.callNum,
//                        book.shelfArea,
//                        book.format,
//                        book.className,
//                        book.bookStatus,
//                        book.rentCnt,
//                        book.isbn,
//                        book.description,
//                        book.regDate
//                ))
//                .from(book)
//                .orderBy(book.rentCnt.desc()) // 인기도서를 rentCnt 내림차순으로 정렬
////                .offset(pageable.getOffset())
//                .limit(20) //상위 20개의 책만 가져옴.
//                .fetchResults();
//		List<Book> content = ppBookresults.getResults();
//		Long total = ppBookresults.getTotal();
//		System.out.println("토탈"+total);
//						return content;
//								//new PageImpl<>(content, pageable, total);
//	}
//
//
//}
