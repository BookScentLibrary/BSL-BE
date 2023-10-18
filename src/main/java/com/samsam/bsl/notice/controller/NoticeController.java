package com.samsam.bsl.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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

import com.samsam.bsl.notice.dto.NoticeDTO;
import com.samsam.bsl.notice.dto.NoticeRequestDTO;
import com.samsam.bsl.notice.service.NoticeService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;


	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@GetMapping("/noticeList")
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
			// keyword 파라미터가 없을 경우 모든 공지사항을 불러오는 동작을 수행
			List<NoticeDTO> allNoticeDTOList = noticeService.getNoticeList();

			if (allNoticeDTOList.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(allNoticeDTOList);
			}
		}
	}

	@PostMapping("/noticeWrite")
	public ResponseEntity<?> writeNtice(@RequestBody NoticeRequestDTO noticeRequestDTO) {
		// 이제 ReviewRequestDTO를 사용하여 게시물 작성
		int result = noticeService.savePost(noticeRequestDTO);

		if (result == 1) {
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패");
		}
	}

	// 공지사항 상세보기
	@GetMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<NoticeDTO> detail(@PathVariable("not_postId") Integer not_postId) {
		NoticeDTO noticeDTO = noticeService.getNotice(not_postId);
		return ResponseEntity.ok(noticeDTO);
	}

	// 공지사항 수정
	@PutMapping("/noticeEdit/{not_postId}")
	public ResponseEntity<NoticeDTO> updateNotice(@PathVariable("not_postId") Integer not_postId,
			@RequestBody NoticeDTO noticeDTO) {
		NoticeDTO updatedNotice = noticeService.updateNotice(not_postId, noticeDTO);
		return ResponseEntity.ok(updatedNotice);
	}

	// 공지사항 삭제
	@DeleteMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<Void> delete(@PathVariable("not_postId") Integer not_postId) {
		noticeService.deletePost(not_postId);
		return ResponseEntity.noContent().build();
	}

}
