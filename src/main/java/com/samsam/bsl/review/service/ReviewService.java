package com.samsam.bsl.review.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsam.bsl.review.dto.ReviewDTO;
import com.samsam.bsl.review.model.Review;
import com.samsam.bsl.review.repository.ReviewRepository;

import lombok.AllArgsConstructor;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
	private static final int PAGE_POST_COUNT = 4;


	
	public List<ReviewDTO> getAllReviewsWithUserInfo() {
	    List<Review> reviews = reviewRepository.getAllReviews(); 
	    System.out.println("디버깅"+reviews.toString());
	    return reviews.stream().map(this::convertEntityToDtoWithUserInfo).collect(Collectors.toList());
	}

	private ReviewDTO convertEntityToDtoWithUserInfo(Review review) {
	    ReviewDTO dto = new ReviewDTO();
	    dto.setRev_postId(review.getRev_postId());
	    dto.setPostTitle(review.getPostTitle());
	    dto.setContent(review.getContent());
	    dto.setCreatedAt(review.getCreatedAt());
	    dto.setIsbn(review.getIsbn());
	    dto.setRate(review.getRate());
	    dto.setNickname(review.getUser().getNickname()); // Users 엔터티에서 nickname 가져오기
	    dto.setBookname(review.getBook().getBookname()); // Book 엔터티에서 bookname 가져오기
	    return dto;
	}

	@Transactional
	public List<ReviewDTO> getReviewList(Integer pageNum) {
		Page<Review> page = reviewRepository
				.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdAt")));

		List<Review> reviews = page.getContent();
		List<ReviewDTO> reviewDTOList = new ArrayList<>();

		for (Review review : reviews) {
			reviewDTOList.add(this.convertEntityToDto(review));
		}

		return reviewDTOList;
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

	private ReviewDTO convertEntityToDto(Review review) {
		return ReviewDTO.builder().userId(review.getUserId()).bookNo(review.getBookNo())
				.rev_postId(review.getRev_postId()).postTitle(review.getPostTitle()).content(review.getContent())
				.createdAt(review.getCreatedAt()).isbn(review.getIsbn()).rate(review.getRate()).build();
	}

	public Integer[] getPageList(Integer curPageNum) {
		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

		// 총 게시글 갯수
		Double postsTotalCount = Double.valueOf(this.getReviewCount());

		// 총 게시글 기준으로 계산한 마지막 페이지 번호 계산
		Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

		// 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
				? curPageNum + BLOCK_PAGE_NUM_COUNT
				: totalLastPageNum;

		// 페이지 시작 번호 조정
		curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

		// 페이지 번호 할당
		for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
			pageList[idx] = val;
		}

		return pageList;
	}

}