package com.samsam.bsl.newbook;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.samsam.bsl.newbook.QNewBook.newBook;
import static com.samsam.bsl.book.rent.domain.QBook.book;

public class NewBookRepositoryImpl implements NewBookRepositoryQueryDsl {
  private final JPAQueryFactory queryFactory;
  public NewBookRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }


  @Override
  public List<NewBookDTO> getNewBooks() {

    List<NewBook> bookNos = queryFactory
      .selectFrom(newBook)
      .fetch();

    List<NewBookDTO> NewBooks = new ArrayList<NewBookDTO>();
    for(int i=0; i<bookNos.size(); i++) {
      Book b = queryFactory
        .selectFrom(book)
        .where(book.bookNo.eq(bookNos.get(i).getBookNo()))
        .fetchOne();

      NewBookDTO nb = new NewBookDTO();

      nb.setBookNo(b.getBookNo());
      nb.setBookname(b.getBookname());
      nb.setAuthor(b.getAuthor());
      nb.setPublisher(b.getPublisher());
      nb.setPublicationYear(b.getPublicationYear());
      nb.setRegDate(b.getRegDate());

      NewBooks.add(nb);
    }
    return NewBooks;
  }
}
