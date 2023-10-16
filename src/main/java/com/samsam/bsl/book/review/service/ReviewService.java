package com.samsam.bsl.book.review.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

<<<<<<< HEAD
import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.domain.ReviewRequestDTO;
=======
import com.samsam.bsl.book.review.domain.Comment;
import com.samsam.bsl.book.review.domain.RatingData;
import com.samsam.bsl.book.review.domain.Review;
import com.samsam.bsl.book.review.dto.CommentDTO;
>>>>>>> e8134c87a2e86f0bad287fcf713013aa695b62a3
import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.repository.CommentRepository;
import com.samsam.bsl.book.review.repository.RatingDataRepository;
import com.samsam.bsl.book.review.repository.ReviewRepository;
<<<<<<< HEAD
import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.user.dto.ResponseDTO;
=======
import com.samsam.bsl.notice.dto.NoticeDTO;
>>>>>>> e8134c87a2e86f0bad287fcf713013aa695b62a3
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
<<<<<<< HEAD
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;
=======
	private RatingDataRepository ratingDataRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Transactional
	public void updateRatingData(int bookNo, int rate) {
		RatingData ratingData = ratingDataRepository.findByBookNo(bookNo);

		if (ratingData == null) {
			// 해당 bookNo에 대한 레코드가 없는 경우 새 레코드를 생성
			ratingData = new RatingData();
			ratingData.setBookNo(bookNo);
		}

		// 선택한 평점(rate)에 따라 해당 칼럼을 업데이트
		switch (rate) {
		case 1:
			ratingData.setPoint_1(ratingData.getPoint_1() + 1);
			break;
		case 2:
			ratingData.setPoint_2(ratingData.getPoint_2() + 1);
			break;
		case 3:
			ratingData.setPoint_3(ratingData.getPoint_3() + 1);
			break;
		case 4:
			ratingData.setPoint_4(ratingData.getPoint_4() + 1);
			break;
		case 5:
			ratingData.setPoint_5(ratingData.getPoint_5() + 1);
			break;
		}

		ratingDataRepository.save(ratingData);
	}
>>>>>>> e8134c87a2e86f0bad287fcf713013aa695b62a3

//	@Autowired
//	private UserRepository userRepository;
//
//	public ReviewDTO createReview(ReviewDTO reviewDTO, String username) {
//		// 현재 로그인한 사용자의 ID(username)를 사용하여 사용자 정보를 가져옴
//		Optional<UserEntity> userOptional = userRepository.findByUsername(username);
//
//		if (userOptional.isPresent()) {
//			UserEntity user = userOptional.get();
//
//			// 리뷰 작성 시 rev_postId는 자동으로 생성되므로 입력할 필요 없음
//			// 사용자의 ID와 닉네임을 리뷰 정보에 저장
//			reviewDTO.setUserId(user.getUserId());
//			reviewDTO.setNickname(user.getNickname());
//
//			// ReviewDTO를 Review 엔티티로 변환하여 저장
//			Review review = reviewDTO.toEntity();
//			reviewRepository.save(review);
//
//			return reviewDTO;
//		}
//
//		return null; // 사용자 정보를 찾지 못한 경우
//	}
	
	//리뷰리스트 가져옴
//	@Transactional
//	public List<ReviewDTO> getReviewList() {
//		List<Review> reviews = reviewRepository.getAllReviews();
//		List<ReviewDTO> reviewDTOList = new ArrayList<>();
//		for (Review review : reviews) {
//			reviewDTOList.add(this.convertEntityToDto(review));
//		}
//
//		return reviewDTOList;
//	}
	
	@Transactional
	public List<Review> getReviewList() {
	    return reviewRepository.getAllReviews();
	}

//	@Transactional
//	public Page<ReviewDTO> getReviewList() {
//	    // Pageable 객체를 사용하여 정렬 조건 설정
//	    Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "createdAt"));
//
//	    Page<Review> reviews = reviewRepository.findAll(pageable);
//	    Page<ReviewDTO> reviewDTOPage = reviews.map(this::convertEntityToDto);
//
//	    return reviewDTOPage;
//	}

	private ReviewDTO convertEntityToDto(Review review) {
		return ReviewDTO.builder().userId(review.getUserId()).bookNo(review.getBookNo())
				.rev_postId(review.getRev_postId()).postTitle(review.getPostTitle()).content(review.getContent())
				.createdAt(review.getCreatedAt()).modifiedAt(review.getModifiedAt()).isbn(review.getIsbn())
				.rate(review.getRate()).nickname(review.getUser().getNickname())
				.bookname(review.getBook().getBookname()).bookImageURL(review.getBook().getBookImageURL())
				.author(review.getBook().getAuthor()).publisher(review.getBook().getPublisher())
				.callNum(review.getBook().getCallNum()).shelfArea(review.getBook().getShelfArea()).build();
	}

	public List<ReviewDTO> getReviewsPerPage(int perPage, int pageNum) {
		Pageable pageable = PageRequest.of(pageNum - 1, perPage, Sort.by(Sort.Direction.ASC, "createdAt"));
		Page<Review> page = reviewRepository.findAll(pageable);
		List<ReviewDTO> reviews = page.map(this::convertEntityToDto).getContent();
		return reviews;
	}

	@Transactional
	public Long getReviewCount() {
		return reviewRepository.count();
	}

	@Transactional
	public ReviewDTO getPost(Integer rev_postId) {
		Optional<Review> reviewWrapper = reviewRepository.findById(rev_postId);
		Review review = reviewWrapper.get();

		return this.convertEntityToDto(review);
	}

	// 리뷰작성
//	@Transactional
//	public Integer savePost(ReviewDTO reviewDTO) {
//		return reviewRepository.save(reviewDTO.toEntity()).getRev_postId();
//	}
	@Transactional
	public int savePost(ReviewRequestDTO reviewRequestDTO) {
		Review review = new Review();
		review.setPostTitle(reviewRequestDTO.getPostTitle());
		review.setContent(reviewRequestDTO.getContent());
		review.setBookNo(reviewRequestDTO.getBookNo());
		review.setUserId(reviewRequestDTO.getUserId());
		review.setRate(reviewRequestDTO.getRate());
		review.setIsbn(reviewRequestDTO.getIsbn());

		try {
			reviewRepository.save(review);
			System.out.println("굿");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	

	@Transactional
	public void deletePost(Integer rev_postId) {
		reviewRepository.deleteById(rev_postId);
	}

//	@Transactional
//	public int update(int rev_postId, ReviewDTO reviewDTO) {
//
//		Review review = reviewRepository.findById(rev_postId)
//				.orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
//		review.update(reviewDTO.getPostTitle(), reviewDTO.getCreatedAt(), reviewDTO.getRate(), reviewDTO.getNickname(),
//				reviewDTO.getContent(), reviewDTO.getBookNo(), reviewDTO.getBookname(), reviewDTO.getAuthor(),
//				reviewDTO.getPublisher(), reviewDTO.getCallNum(), reviewDTO.getShelfArea());
//		return rev_postId;
//	}

//	@Transactional
//	public int update(int rev_postId, ReviewDTO reviewDTO) {
//		Optional<Review> optionalReview = reviewRepository.findById(rev_postId);
//
//		if (optionalReview.isPresent()) {
//			Review review = optionalReview.get();
//			review.update(reviewDTO.getPostTitle(), reviewDTO.getCreatedAt(), reviewDTO.getRate(),
//					reviewDTO.getNickname(), reviewDTO.getContent(), reviewDTO.getBookNo(), reviewDTO.getBookname(),
//					reviewDTO.getAuthor(), reviewDTO.getPublisher(), reviewDTO.getCallNum(), reviewDTO.getShelfArea());
//			return rev_postId;
//		} else {
//			// rev_postId에 해당하는 리뷰를 찾지 못한 경우, 다른 처리를 수행하거나 예외를 던질 수 있습니다.
//			// 여기에 원하는 로직을 추가하세요.
//			return "해당 리뷰를 찾지 못했습니다"; // 예를 들어 -1을 반환하여 리뷰를 찾지 못했음을 표시할 수 있습니다.
//		}
//	}

//	@Transactional
//	public void modify(ReviewDTO reviewDTO) {
//		// getOne() : 필요한 순간까지 로딩을 지연하는 방식
//		 Optional<Review> optionalReview = reviewRepository.findById(reviewDTO.getRev_postId());
//
//		 if (optionalReview.isPresent()) {
//		        Review review = optionalReview.get();
//		        review.changePostTitle(reviewDTO.getPostTitle());
//		        review.changeCreatedAt(reviewDTO.getCreatedAt());
//		        review.changeRate(reviewDTO.getRate());
//		        review.changeNickname(reviewDTO.getNickname());
//		        review.changeContent(reviewDTO.getContent());
//		        review.changeBookNo(reviewDTO.getBookNo());
//		        review.changeBookname(reviewDTO.getBookname());
//		        review.changeAuthor(reviewDTO.getAuthor());
//		        review.changePublisher(reviewDTO.getPublisher());
//		        review.changeCallNum(reviewDTO.getCallNum());
//		        review.changeShelfArea(reviewDTO.getShelfArea());
//
//		        reviewRepository.save(review);
//		 }
//	}

	// 리뷰를 제목, 저자, 출판사로 검색할 수 있는 메서드 추가
//	@Transactional
//	public List<ReviewDTO> searchPosts(String keyword, String searchType) {
//		List<Review> reviews = new ArrayList<>();
//
//		if ("all".equals(searchType)) {
//			reviews = reviewRepository
//					.findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
//							keyword, keyword, keyword, keyword, keyword, keyword);
//		} else if ("bookname".equals(searchType)) {
//			reviews = reviewRepository.findByBook_booknameContaining(keyword); // Book 엔티티의 bookname을 사용
//		} else if ("postTitle".equals(searchType)) {
//			reviews = reviewRepository.findByPostTitleContaining(keyword); // Book 엔티티의 bookname을 사용
//		} else if ("author".equals(searchType)) {
//			reviews = reviewRepository.findByBook_authorContaining(keyword);
//		} else if ("publisher".equals(searchType)) {
//			reviews = reviewRepository.findByBook_publisherContaining(keyword);
//		} else if ("callNum".equals(searchType)) {
//			reviews = reviewRepository.findByBook_callNumContaining(keyword);
//		} else if ("publicationYear".equals(searchType)) {
//			reviews = reviewRepository.findByBook_publicationYearContaining(keyword);
//		}
//
//		return reviews.stream().map(this::convertEntityToDto).collect(Collectors.toList());
//	}
	@Transactional
	public List<Review> searchPosts(String keyword, String searchType) {
	    if ("all".equals(searchType)) {
	        return reviewRepository.findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
	                keyword, keyword, keyword, keyword, keyword, keyword
	        );
	    } else if ("bookname".equals(searchType)) {
	        return reviewRepository.findByBook_booknameContaining(keyword);
	    } else if ("postTitle".equals(searchType)) {
	        return reviewRepository.findByPostTitleContaining(keyword);
	    } else if ("author".equals(searchType)) {
	        return reviewRepository.findByBook_authorContaining(keyword);
	    } else if ("publisher".equals(searchType)) {
	        return reviewRepository.findByBook_publisherContaining(keyword);
	    } else if ("callNum".equals(searchType)) {
	        return reviewRepository.findByBook_callNumContaining(keyword);
	    } else if ("publicationYear".equals(searchType)) {
	        return reviewRepository.findByBook_publicationYearContaining(keyword);
	    }

	    return Collections.emptyList(); // Return an empty list if no matches found.
	}

	@Transactional
	public void updateReview(ReviewDTO reviewDTO) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewDTO.getRev_postId());

		if (optionalReview.isPresent()) {
			Review review = optionalReview.get();

			// 리뷰 업데이트에 필요한 정보를 ReviewDTO에서 가져와서 업데이트
			review.setPostTitle(reviewDTO.getPostTitle());
			review.setRate(reviewDTO.getRate());
			review.setContent(reviewDTO.getContent());
			review.setBookNo(reviewDTO.getBookNo());
			review.setCreatedAt(reviewDTO.getCreatedAt());
			review.setModifiedAt(reviewDTO.getModifiedAt());
			review.setIsbn(reviewDTO.getIsbn());
//	        review.setBookImageURL(reviewDTO.getBookImageURL());
//	        review.setBookname(reviewDTO.getBookname());
//	        review.setAuthor(reviewDTO.getAuthor());
//	        review.setPublisher(reviewDTO.getPublisher());
//	        review.setCallNum(reviewDTO.getCallNum());
//	        review.setShelfArea(reviewDTO.getShelfArea());

<<<<<<< HEAD
=======
			// 리뷰 업데이트에 필요한 정보를 ReviewDTO에서 가져와서 업데이트
			review.setPostTitle(reviewDTO.getPostTitle());
			review.setRate(reviewDTO.getRate());
			review.setContent(reviewDTO.getContent());
			review.setBookNo(reviewDTO.getBookNo());

>>>>>>> e8134c87a2e86f0bad287fcf713013aa695b62a3
			// ReviewRepository를 사용하여 업데이트
			reviewRepository.save(review);
		}
	}
<<<<<<< HEAD
=======

//	// 댓글작성
//	@Transactional
//	public Integer saveComment(CommentDTO commentDTO) {
//		return commentRepository.save(commentDTO.toEntity()).getCommentId();
//	}
//
//	// 댓글수정
//	@Transactional
//	public void updateComment(CommentDTO commentDTO) {
//		Optional<Comment> optionalComment = commentRepository.findById(commentDTO.getCommentId());
//
//		if (optionalComment.isPresent()) {
//			Comment comment = optionalComment.get();
//
//			// 리뷰 업데이트에 필요한 정보를 ReviewDTO에서 가져와서 업데이트
//			comment.setContent(commentDTO.getContent());
//
//			// ReviewRepository를 사용하여 업데이트
//			commentRepository.save(comment);
//		}
//	}
//	
//	//댓글삭제
//	@Transactional
//	public void deleteComment(Integer commentId) {
//		commentRepository.deleteById(commentId);
//	}

//	public CommentDTO addComment(int rev_postId, CommentDTO commentDTO) {
//        Review review = reviewRepository.findById(rev_postId)
//                .orElseThrow(() -> new ReviewNotFoundException("Review not found"));
//
//        Comment comment = commentDTO.toEntity();
//        comment.setReview(review);
//
//        commentRepository.save(comment);
//
//        return convertCommentEntityToDto(comment); // Convert and return the added comment as DTO
//    }
//
//    public CommentDTO updateComment(int commentId, CommentDTO commentDTO) {
//        Comment comment = commentRepository.findById(commentId)
//                .orElseThrow(() -> new CommentNotFoundException("Comment not found"));
//
//        // Update the content and modifiedAt
//        comment.setContent(commentDTO.getContent());
//        comment.setModifiedAt(LocalDateTime.now());
//
//        commentRepository.save(comment);
//
//        return convertCommentEntityToDto(comment); // Convert and return the updated comment as DTO
//    }
//
//    public void deleteComment(int commentId) {
//        commentRepository.deleteById(commentId);
//    }
//    
//    private CommentDTO convertCommentEntityToDto(Comment comment) {
//        CommentDTO commentDTO = new CommentDTO();
//        commentDTO.setCommentId(comment.getCommentId());
//        commentDTO.setContent(comment.getContent());
//        commentDTO.setCreatedAt(comment.getCreatedAt());
//        commentDTO.setModifiedAt(comment.getModifiedAt());
//        // You can set other fields as needed
//
//        return commentDTO;
//    }
>>>>>>> e8134c87a2e86f0bad287fcf713013aa695b62a3

}