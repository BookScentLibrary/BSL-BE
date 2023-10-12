package com.samsam.bsl.book.review.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.model.Review;
import com.samsam.bsl.book.review.repository.ReviewRepository;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

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

	@Transactional
	public List<ReviewDTO> getReviewList() {
		List<Review> reviews = reviewRepository.getAllReviews();
		List<ReviewDTO> reviewDTOList = new ArrayList<>();
		for (Review review : reviews) {
			reviewDTOList.add(this.convertEntityToDto(review));
		}

		return reviewDTOList;
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
				.bookname(review.getBook().getBookname()).author(review.getBook().getAuthor())
				.publisher(review.getBook().getPublisher()).callNum(review.getBook().getCallNum())
				.shelfArea(review.getBook().getShelfArea()).build();
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
	@Transactional
	public Integer savePost(ReviewDTO reviewDTO) {
		return reviewRepository.save(reviewDTO.toEntity()).getRev_postId();
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
	@Transactional
	public List<ReviewDTO> searchPosts(String keyword, String searchType) {
		List<Review> reviews = new ArrayList<>();

		if ("all".equals(searchType)) {
			reviews = reviewRepository
					.findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
							keyword, keyword, keyword, keyword, keyword, keyword);
		} else if ("bookname".equals(searchType)) {
			reviews = reviewRepository.findByBook_booknameContaining(keyword); // Book 엔티티의 bookname을 사용
		} else if ("postTitle".equals(searchType)) {
			reviews = reviewRepository.findByPostTitleContaining(keyword); // Book 엔티티의 bookname을 사용
		} else if ("author".equals(searchType)) {
			reviews = reviewRepository.findByBook_authorContaining(keyword);
		} else if ("publisher".equals(searchType)) {
			reviews = reviewRepository.findByBook_publisherContaining(keyword);
		} else if ("callNum".equals(searchType)) {
			reviews = reviewRepository.findByBook_callNumContaining(keyword);
		} else if ("publicationYear".equals(searchType)) {
			reviews = reviewRepository.findByBook_publicationYearContaining(keyword);
		}

		return reviews.stream().map(this::convertEntityToDto).collect(Collectors.toList());
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
	        review.setBookImageURL(reviewDTO.getBookImageURL());
	        review.setBookname(reviewDTO.getBookname());
	        review.setAuthor(reviewDTO.getAuthor());
	        review.setPublisher(reviewDTO.getPublisher());
	        review.setCallNum(reviewDTO.getCallNum());
	        review.setShelfArea(reviewDTO.getShelfArea());

	        // ReviewRepository를 사용하여 업데이트
	        reviewRepository.save(review);
	    }
	}


}