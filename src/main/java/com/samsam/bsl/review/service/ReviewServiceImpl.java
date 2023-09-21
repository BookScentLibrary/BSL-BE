package com.samsam.bsl.review.service;

import org.springframework.stereotype.Service;

import com.samsam.bsl.review.controller.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository; // 리포지토리를 주입받아야 함

    @Override
    public List<Books> getAllBooks() {
        return reviewRepository.getAllBooks(); // 리포지토리를 통해 모든 도서 정보를 가져옴
    }

    @Override
    public List<PostReviewDTO> getAllPostReviews() {
        return reviewRepository.getAllPostReviews(); // 리포지토리를 통해 모든 리뷰 정보를 가져옴
    }

    @Override
    public List<CommentReview> getCommentReviewsByPostId(int postId) {
        return reviewRepository.getCommentReviewsByPostId(postId); // 특정 리뷰에 대한 댓글 정보를 가져옴
    }

    @Override
    public void createPostReview(PostReviewDTO postReview) {
        reviewRepository.createPostReview(postReview); // 새로운 리뷰를 생성
    }

    @Override
    public void createCommentReview(CommentReview commentReview) {
        reviewRepository.createCommentReview(commentReview); // 새로운 댓글을 생성
    }

    // 기타 필요한 메서드의 구현

    // 도서 관련 메서드
    @Override
    public Books getBookByISBN(String isbn) {
        return reviewRepository.getBookByISBN(isbn); // ISBN으로 도서 정보를 가져옴
    }

    @Override
    public List<Books> searchBooksByTitle(String title) {
        return reviewRepository.searchBooksByTitle(title); // 제목으로 도서 검색
    }

    @Override
    public List<Books> searchBooksByAuthor(String author) {
        return reviewRepository.searchBooksByAuthor(author); // 저자로 도서 검색
    }

    @Override
    public List<Books> searchBooksByPublisher(String publisher) {
        return reviewRepository.searchBooksByPublisher(publisher); // 발행처로 도서 검색
    }

    // 리뷰 관련 메서드
    @Override
    public PostReviewDTO getPostReviewById(int postId) {
        return reviewRepository.getPostReviewById(postId); // 리뷰 ID로 리뷰 정보를 가져옴
    }

    @Override
    public void updatePostReview(PostReviewDTO postReview) {
        reviewRepository.updatePostReview(postReview); // 리뷰를 수정
    }

    @Override
    public void deletePostReview(int postId) {
        reviewRepository.deletePostReview(postId); // 리뷰를 삭제
    }

    // 유저 관련 메서드
    @Override
    public UsersDTO getUserById(int userId) {
        return reviewRepository.getUserById(userId); // 유저 ID로 유저 정보를 가져옴
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return reviewRepository.getAllUsers(); // 모든 유저 정보를 가져옴
    }

    @Override
    public void createUser(UsersDTO user) {
        reviewRepository.createUser(user); // 새로운 유저 생성
    }

    @Override
    public void updateUser(UsersDTO user) {
        reviewRepository.updateUser(user); // 유저 정보를 수정
    }

    @Override
    public void deleteUser(int userId) {
        reviewRepository.deleteUser(userId); // 유저를 삭제
    }
}
