package com.samsam.bsl.mypage.service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.domain.RentHistory;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.rent.repository.RentRepository;
import com.samsam.bsl.book.rent.repository.ReturnRepository;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.mypage.dto.CountDTO;
import com.samsam.bsl.mypage.repository.MyPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyPageService {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReturnRepository returnRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MyPageRepository myPageRepository;


    public CountDTO getCount(String userId) {
        try {
            Long rentCnt = returnRepository.countByUserId(userId);
            Long reviewCnt = reviewRepository.countByUserId(userId);
//      Long programCnt = programRepository.countByUserId(userId);
            CountDTO cnt = new CountDTO(rentCnt, reviewCnt);
            return cnt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Review> getReviews(String userId) {
        try {
            return myPageRepository.findAllByUserIdOrderByCreatedAtDesc(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Review> getReviewMain(String userId) {
        try {
            return myPageRepository.getMyReviewMain(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RentHistory> getRentHistoryMain(String userId) {
        try {
            return returnRepository.findTop5ByUserIdOrderByRentedDateDesc(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> getBookList(List<Integer> bookNos) {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < bookNos.size(); i++) {
            Book book = bookRepository.findByBookNo(bookNos.get(i));
            books.add(book);
        }
        return books;
    }
}

