package com.samsam.bsl.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.service.ReviewService;
import com.samsam.bsl.notice.dto.NoticeDTO;
import com.samsam.bsl.notice.service.NoticeService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/notice")
	public ResponseEntity<List<NoticeDTO>> handleNoticeListRequest(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "searchType", defaultValue = "all") String searchType) {

		// keyword 파라미터가 있을 경우 검색 동작을 수행
		if (keyword != null && !keyword.isEmpty()) {
			List<NoticeDTO> noticeDTOList = noticeService.searchPosts(keyword, searchType);

			if (noticeDTOList.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(noticeDTOList);
			}
		} else {
			// keyword 파라미터가 없을 경우 모든 리뷰를 불러오는 동작을 수행
			List<NoticeDTO> allNoticeDTOList = noticeService.getNoticeList();

			if (allNoticeDTOList.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(allNoticeDTOList);
			}
		}
	}

	// 리뷰상세보기
	@GetMapping("/noticeDetail/{rev_postId}")
	public ResponseEntity<ReviewDTO> detail(@PathVariable("rev_postId") Integer rev_postId) {
		ReviewDTO reviewDTO = reviewService.getPost(rev_postId);
		return ResponseEntity.ok(reviewDTO);
	}

	// 리뷰쓰기
	@PostMapping("/noticeWrite")
	public ResponseEntity<Void> write(@RequestBody NoticeDTO noticeDTO) {
		noticeService.savePost(noticeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	// 리뷰수정
	@PutMapping("/noticeEdit/{rev_postId}")
	public ResponseEntity<Void> update(@PathVariable("rev_postId") Integer rev_postId,
			@RequestBody ReviewDTO reviewDTO) {
		reviewDTO.setRev_postId(rev_postId); // 리뷰 ID 설정
	    reviewService.updateReview(reviewDTO); // 리뷰 수정 서비스 호출
	    return ResponseEntity.ok().build();
	}

	// 리뷰삭제
	@DeleteMapping("/noticeDetail/{rev_postId}")
	public ResponseEntity<Void> delete(@PathVariable("rev_postId") Integer rev_postId) {
		reviewService.deletePost(rev_postId);
		return ResponseEntity.noContent().build();
	}

}
