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
		return ReviewDTO
				.builder()
				.userId(review.getUserId())
				.bookNo(review.getBookNo())
				.rev_postId(review.getRev_postId())
				.postTitle(review.getPostTitle())
				.content(review.getContent())
				.createdAt(review.getCreatedAt())
				.modifiedAt(review.getModifiedAt())
				.isbn(review.getIsbn())
				.rate(review.getRate())
				.nickname(review.getUser().getNickname())
				.bookname(review.getBook().getBookname())
				.author(review.getBook().getAuthor())
				.publisher(review.getBook().getPublisher())
				.callNum(review.getBook().getCallNum())
				.shelfArea(review.getBook().getShelfArea())
				.build();
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
	
//	public Page<ReviewDTO> searchPosts(String keyword, String searchType, Pageable pageable) {
//		Page<Review> reviews = new PageImpl<>(new ArrayList<>()); // 초기화
//
//		if ("all".equals(searchType)) {
//		    reviews = reviewRepository
//		            .findByBook_booknameContainingOrPostTitleContainingOrBook_authorContainingOrBook_publisherContainingOrBook_callNumContainingOrBook_publicationYearContaining(
//		                    keyword, keyword, keyword, keyword, keyword, keyword, pageable);
//		} else if ("bookname".equals(searchType)) {	
//		    reviews = reviewRepository.findByBook_booknameContaining(keyword, pageable); // Book 엔티티의 bookname을 사용
//		} else if ("postTitle".equals(searchType)) {
//		    reviews = reviewRepository.findByPostTitleContaining(keyword, pageable); // Book 엔티티의 bookname을 사용
//		} else if ("author".equals(searchType)) {
//		    reviews = reviewRepository.findByBook_authorContaining(keyword, pageable);
//		} else if ("publisher".equals(searchType)) {
//		    reviews = reviewRepository.findByBook_publisherContaining(keyword, pageable);
//		} else if ("callNum".equals(searchType)) {
//		    reviews = reviewRepository.findByBook_callNumContaining(keyword, pageable);
//		} else if ("publicationYear".equals(searchType)) {
//		    reviews = reviewRepository.findByBook_publicationYearContaining(keyword, pageable);
//		}
//
//
//	    List<ReviewDTO> reviewDTOList = reviews.stream().map(this::convertEntityToDto).collect(Collectors.toList());
//	    return new PageImpl<>(reviewDTOList, pageable, reviewDTOList.size());
//	}


}