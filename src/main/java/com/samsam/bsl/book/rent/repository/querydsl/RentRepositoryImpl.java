package com.samsam.bsl.book.rent.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.Rent;
import com.samsam.bsl.book.rent.dto.RentedBook;
import com.samsam.bsl.user.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import static com.samsam.bsl.book.rent.domain.QRent.rent;
import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.rent.domain.QReader.reader;
import static com.samsam.bsl.user.entity.QUserEntity.userEntity;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class RentRepositoryImpl implements RentRepositoryQueryDsl {
    private final JPAQueryFactory queryFactory;

    static final int SUCCESS = 1;
    static final int FAIL = 0;

    public RentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    @Transactional
    public int updateBookStatus(String username, int bookNo){
        Long bookResult = queryFactory
                .update(book)
                .set(book.bookStatus, 1)
                .set(book.rentCnt, book.rentCnt.add(1))
                .where(book.bookNo.eq(bookNo))
                .execute();

        if(bookResult==0) {
            return FAIL; // 변겅한 행이 없는 경우(실패)
        }

        UserEntity user = queryFactory
                .selectFrom(userEntity)
                .where(userEntity.username.eq(username))
                .fetchOne();

        int age = user.getUserAge();
        String gender = user.getGender();

        Long readerResult=0L;
        if(gender.equals("여")){
            if(age<20) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_10, reader.f_10.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<30) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_20, reader.f_20.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<40) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_30, reader.f_30.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<50) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_40, reader.f_40.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<60) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_50, reader.f_50.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age>=60) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.f_senior, reader.f_senior.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            }
        } else {
            if(age<20) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_10, reader.m_10.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<30) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_20, reader.m_20.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<40) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_30, reader.m_30.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<50) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_40, reader.m_40.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age<60) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_50, reader.m_50.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            } else if(age>=60) {
                readerResult = queryFactory
                        .update(reader)
                        .set(reader.m_senior, reader.m_senior.add(1))
                        .where(reader.bookNo.eq(bookNo))
                        .execute();
            }
        }

        if(readerResult == 0) {
            return FAIL;
        } else {
            return SUCCESS;
        }
    };

    @Override
    public List<RentedBook> getUsersRentBook(String username) {

        List<Rent> userdata = queryFactory
                .selectFrom(rent)
                .where(rent.username.eq(username))
                .fetch();
        List<RentedBook> rentedBooks = new ArrayList<RentedBook>();

        for (int i = 0; i < userdata.size(); i++) {
            RentedBook rentedBook = new RentedBook();
            Book b = queryFactory
                    .selectFrom(book)
                    .where(book.bookNo.eq(userdata.get(i).getBookNo()))
                    .fetchOne();
            rentedBook.setBook(b);
            rentedBook.setRentDate(userdata.get(i).getRentDate());
            rentedBook.setExpireDate(userdata.get(i).getExpireDate());
            rentedBooks.add(rentedBook);
        }
        return rentedBooks;
    }

    @Override
    public int RentedBookCnt(String username) {
        List<Rent> result = queryFactory
                .selectFrom(rent)
                .where(rent.username.eq(username))
                .fetch();
        return result.size();
    }

    @Override
    @Transactional
    public int returnBook(String username, int bookNo) {
        Long result = queryFactory
                .update(book)
                .set(book.bookStatus, 0)
                .where(book.bookNo.eq(bookNo))
                .execute();

        if(result == 0) {
            return FAIL; // 변경된 행이 없음
        }

        Long deleteRent = queryFactory
                .delete(rent)
                .where(rent.bookNo.eq(bookNo))
                .execute();

        if(deleteRent==0) {
            return FAIL; // 삭제된 행이 없음
        } else {
            return SUCCESS;
        }
    }
}
