package com.samsam.bsl.review.controller;

public interface ReviewService {
	List<Books> getAllBooks();
    List<PostReviewDTO> getAllPostReviews();
    List<CommentReview> getCommentReviewsByPostId(int postId);
    private void createPostReview(PostReviewDTO postReview);
    private void createCommentReview(CommentReview commentReview);
    
 // 도서 관련 메서드
    Books getBookByISBN(String isbn);
    List<Books> searchBooksByTitle(String title);
    List<Books> searchBooksByAuthor(String author);
    List<Books> searchBooksByPublisher(String publisher);
    
 // 리뷰 관련 메서드
    PostReviewDTO getPostReviewById(int postId);
    private void updatePostReview(PostReviewDTO postReview);
    private void deletePostReview(int postId);
    
 // 유저 관련 메서드
    UsersDTO getUserById(int userId);
    List<UsersDTO> getAllUsers();
    private void createUser(UsersDTO user);
    private void updateUser(UsersDTO user);
    private void deleteUser(int userId);
}
