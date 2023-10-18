package com.samsam.bsl.mainpage.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.mainpage.dto.*;
import com.samsam.bsl.notice.domain.Notice;
import com.samsam.bsl.postProgram.model.Program;
import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.samsam.bsl.book.rent.domain.QBook.book;
import static com.samsam.bsl.book.review.domain.QReview.review;
import static com.samsam.bsl.recommend.model.QRecommend.recommend;
import static com.samsam.bsl.notice.domain.QNotice.notice;
import static com.samsam.bsl.postProgram.model.QProgram.program;

public class MainRepositoryImpl implements MainRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Autowired
    UserRepository userRepository;

    static final int SUCCESS = 1;
    static final int FAIL = 0;

    public MainRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MainBook> getNewBook() {
        List<Book> books = queryFactory
                .selectFrom(book)
                .orderBy(book.regDate.desc())
                .limit(3)
                .fetch();

        List<MainBook> bookList = new ArrayList<MainBook>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            MainBook mb = new MainBook();

            mb.setBookNo(book.getBookNo());
            mb.setBookname(book.getBookname());
            mb.setBookImageURL(book.getBookImageURL());
            mb.setAuthor(book.getAuthor().split(";")[0]);

            bookList.add(mb);
        }

        return bookList;
    }

    @Override
    public List<MainNotice> getNotice() {
        List<Notice> result = queryFactory
                .selectFrom(notice)
                .orderBy(notice.createdAt.desc())
                .limit(4)
                .fetch();
        List<MainNotice> noticeList = new ArrayList<MainNotice>();
        for (int i = 0; i < result.size(); i++) {
            Notice notice = result.get(i);
            MainNotice mn = new MainNotice();

            mn.setCreatedAt(notice.getCreatedAt().toString());
            mn.setPostTitle(notice.getPostTitle());
            mn.setPro_postId(notice.getNot_postId());

            noticeList.add(mn);
        }
        return noticeList;
    }

    @Override
    public List<MainProgram> getProgram() {
        List<Program> result = queryFactory
                .selectFrom(program)
                .orderBy(program.createdAt.desc())
                .limit(3)
                .fetch();

        List<MainProgram> programList = new ArrayList<MainProgram>();
        for (int i = 0; i < result.size(); i++) {
            Program program = result.get(i);
            MainProgram mp = new MainProgram();


            mp.setCreatedAt(program.getCreatedAt().toString());
            mp.setPostTitle(program.getPostTitle());
            mp.setPro_postId(program.getPro_postId());

            programList.add(mp);
        }
        return programList;
    }

    @Override
    public List<MainBook> getBestseller() {
        List<Book> result = queryFactory
                .selectFrom(book)
                .orderBy(book.rentCnt.desc())
                .limit(8)
                .fetch();

        List<MainBook> books = new ArrayList<MainBook>();
        for (int i = 0; i < result.size(); i++) {
            Book book = result.get(i);
            MainBook mb = new MainBook();

            mb.setBookNo(book.getBookNo());
            mb.setBookname(book.getBookname());
            mb.setAuthor(book.getAuthor().split(";")[0]);
            mb.setBookImageURL(book.getBookImageURL());

            books.add(mb);
        }

        return books;
    }

    @Override
    public List<MainRecomm> getRecommendBook() {
        List<Recommend> result = queryFactory
                .selectFrom(recommend)
                .orderBy(recommend.createdAt.desc())
                .limit(3)
                .fetch();

        List<MainRecomm> recommendList = new ArrayList<MainRecomm>();
        for (int i = 0; i < result.size(); i++) {
            Recommend recomm = result.get(i);
            Book b = queryFactory
                    .selectFrom(book)
                    .where(book.bookNo.eq(recomm.getBookNo()))
                    .fetchOne();
            MainRecomm mr = new MainRecomm();

            mr.setBookname(b.getBookname());
            mr.setAuthor(b.getAuthor());
            mr.setContent(recomm.getContent());
            mr.setBookImageUrl(b.getBookImageURL());
            mr.setRec_postId(recomm.getRecPostId());

            recommendList.add(mr);
        }

        return recommendList;
    }

    @Override
    public List<MainReview> getReview() {
        List<Review> result = queryFactory
                .selectFrom(review)
                .orderBy(review.createdAt.desc())
                .limit(8)
                .fetch();

        List<MainReview> reviewList = new ArrayList<MainReview>();

        for (int i = 0; i < result.size(); i++) {
            MainReview mr = new MainReview();
            Review review = result.get(i);
            Book book = result.get(i).getBook();
            UserEntity user = userRepository.findByUserId(review.getUserId());

            mr.setBookname(book.getBookname());
            mr.setNickname(user.getNickname());
            mr.setPostTitle(review.getPostTitle());
            mr.setRev_postId(review.getRev_postId());
            mr.setCreatedAt(review.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));

            reviewList.add(mr);
        }

        return reviewList;
    }
}
