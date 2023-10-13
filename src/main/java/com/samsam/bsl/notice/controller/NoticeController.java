package com.samsam.bsl.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	// 공지사항작성
	@PostMapping("/noticeWrite")
	public ResponseEntity<Void> write(@RequestBody NoticeDTO noticeDTO) {
		noticeService.savePost(noticeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	@Value("${file.upload-dir}") // application.properties 또는 application.yml에서 설정한 경로
//	private String uploadDir;

//	@PostMapping("/noticeWrite")
//    public ResponseEntity<String> uploadImage(@PathVariable String username, @RequestParam("image") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please select a file to upload.");
//        }
//
//        try {
//            // 이미지 파일을 지정한 디렉토리에 저장
//            String filename = username + "_" + file.getOriginalFilename();
//            File dest = new File(uploadDir, filename);
//            file.transferTo(dest);
//
//            // 성공적으로 저장한 이미지 파일의 경로를 클라이언트로 반환
//            String imageUrl = "/images/" + username + "/" + filename;
//            return ResponseEntity.status(HttpStatus.CREATED).body(imageUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file.");
//        }
//    }

//	@PostMapping("/noticeWrite")
//	public ResponseEntity<Void> write(@RequestPart("image") MultipartFile image,
//			@RequestParam("postTitle") String postTitle, @RequestParam("content") String content) {
//
//		// 이미지를 업로드하고 파일 경로를 반환
//		String imageUrl = noticeService.uploadImage(image);
//
//		// 공지사항 작성
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setPostTitle(postTitle);
//		noticeDTO.setContent(content);
//		noticeDTO.setPostImgURL(imageUrl);
//
//		// 공지사항 저장
//		noticeService.savePost(noticeDTO);
//
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

	// 공지사항 상세보기
	@GetMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<NoticeDTO> detail(@PathVariable("not_postId") Integer not_postId) {
		NoticeDTO noticeDTO = noticeService.getPost(not_postId);
		return ResponseEntity.ok(noticeDTO);
	}

	// 공지사항 수정
	@PutMapping("/noticeEdit/{not_postId}")
	public ResponseEntity<Void> update(@PathVariable("not_postId") Integer not_postId,
			@RequestBody NoticeDTO noticeDTO) {
		noticeDTO.setNot_postId(not_postId); // 공지사항 ID 설정
		noticeService.updateNotice(noticeDTO); // 공지사항 수정 서비스 호출
		return ResponseEntity.ok().build();
	}

	// 공지사항 삭제
	@DeleteMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<Void> delete(@PathVariable("not_postId") Integer not_postId) {
		noticeService.deletePost(not_postId);
		return ResponseEntity.noContent().build();
	}

}
