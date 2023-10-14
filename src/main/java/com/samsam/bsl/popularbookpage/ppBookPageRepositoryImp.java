//package com.samsam.bsl.popularbookpage;
//
//import javax.persistence.EntityManager;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.samsam.bsl.book.rent.domain.Book;
//import com.samsam.bsl.newbook.NewBook;
//import com.samsam.bsl.newbook.NewBookDTO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.samsam.bsl.book.rent.domain.QBook.book;
//import static com.samsam.bsl.popularbookpage.QPPBookEntity.pPBookEntity;
//
//public class ppBookPageRepositoryImp implements ppBookPageRepositoryQueryDsl {
//
//  private final JPAQueryFactory queryFactory;
//
//  public ppBookPageRepositoryImp(EntityManager em) {
//    this.queryFactory = new JPAQueryFactory(em);
//  }
//
//
//  @Override
//  public List<Book> getBestseller() {
//
//
//
//    List<PPBookEntity> bookNos = queryFactory
//      .selectFrom(pPBookEntity)
//      .fetch();
//
//    List<Book> books = new ArrayList<Book>();
//    for(int i=0; i<bookNos.size(); i++) {
//      Book b = queryFactory
//        .selectFrom(book)
//        .where(book.bookNo.eq(bookNos.get(i).getBookNo()))
//        .fetchOne();
//
//      Book book = new Book();
//
//      book.setBookNo(b.getBookNo());
//      book.setBookname(b.getBookname());
//      book.setAuthor(b.getAuthor());
//      book.setPublisher(b.getPublisher());
//      book.setPublicationYear(b.getPublicationYear());
//      book.setRegDate(b.getRegDate());
//
//      books.add(book);
//    }
//    return books;
//  }
//
//
//
//
////
////  List<Book> ppBookresults = queryFactory
////      .selectFrom(book)
////      .orderBy(book.rentCnt.desc()) // 인기도서를 rentCnt 내림차순으로 정렬
//////                .offset(pageable.getOffset())
////      .limit(20) //상위 20개의 책만 가져옴.
////      .fetch();
////    return ppBookresults;
////  }
//
//
//}
