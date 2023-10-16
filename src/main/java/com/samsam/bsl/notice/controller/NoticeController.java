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

import com.samsam.bsl.notice.domain.Images;
import com.samsam.bsl.notice.dto.ImagesDTO;
import com.samsam.bsl.notice.dto.NoticeDTO;
import com.samsam.bsl.notice.service.ImagesService;
import com.samsam.bsl.notice.service.NoticeService;
import com.samsam.bsl.notice.util.MD5Generator;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private ImagesService imagesService;

	public NoticeController(NoticeService noticeService, ImagesService imagesService) {
		this.noticeService = noticeService;
		this.imagesService = imagesService;
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

	@Value("${image.upload.directory}")
	private String imageUploadDirectory;

	@PostMapping("/noticeWrite")
	public ResponseEntity<Void> write(@RequestPart(name = "file", required = false) MultipartFile image,
			@RequestParam("userId") String userId, @RequestParam("postTitle") String postTitle,
			@RequestParam("content") String content) {
		try {
			if (image != null && !image.isEmpty()) {
				String origImgName = image.getOriginalFilename();
				String storedImgName = new MD5Generator(origImgName).toString();
				String imgPath = imageUploadDirectory + File.separator + storedImgName;

				File dest = new File(imgPath);
				image.transferTo(dest);

				ImagesDTO imagesDTO = new ImagesDTO();
				imagesDTO.setOrigImgName(origImgName);
				imagesDTO.setStoredImgName(storedImgName);
				imagesDTO.setImgPath(imgPath);

				Long imgId = imagesService.saveImage(imagesDTO);

				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setUserId(userId);
				noticeDTO.setPostTitle(postTitle);
				noticeDTO.setContent(content);
				noticeDTO.setImgId(imgId);
				noticeService.savePost(noticeDTO);
			} else {
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setUserId(userId);
				noticeDTO.setPostTitle(postTitle);
				noticeDTO.setContent(content);
				noticeService.savePost(noticeDTO);
			}

			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@PostMapping("/noticeWrite")
//	public ResponseEntity<Void> write(@RequestPart("file") MultipartFile images, @RequestBody NoticeDTO noticeDTO) {
//		try {
//			String origImgName = images.getOriginalFilename();
//			String storedImgName = new MD5Generator(origImgName).toString();
//			/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
//			String savePath = System.getProperty("user.dir") + "\\files";
//			/* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
//			if (!new File(savePath).exists()) {
//				try {
//					new File(savePath).mkdir();
//				} catch (Exception e) {
//					e.getStackTrace();
//				}
//			}
//			String imgPath = savePath + "\\" + storedImgName;
//			images.transferTo(new File(imgPath));
//
//			ImagesDTO imagesDTO = new ImagesDTO();
//			imagesDTO.setOrigImgName(origImgName);
//			imagesDTO.setStoredImgName(storedImgName);
//			imagesDTO.setImgPath(imgPath);
//
//			Long imgId = imagesService.saveImage(imagesDTO);
//			noticeDTO.setImgId(imgId);
//			noticeService.savePost(noticeDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	}

	// 공지사항 상세보기
	@GetMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<NoticeDTO> detail(@PathVariable("not_postId") Integer not_postId) {
		NoticeDTO noticeDTO = noticeService.getNotice(not_postId);
		return ResponseEntity.ok(noticeDTO);
	}

	// 공지사항 수정
	//@PutMapping("/noticeEdit/{not_postId}")
	public ResponseEntity<Void> update(@PathVariable("not_postId") Integer not_postId,
			@RequestBody NoticeDTO noticeDTO) {
		// noticeDTO.setNot_postId(not_postId); // 공지사항 ID 설정
		noticeService.savePost(noticeDTO); // 공지사항 수정 서비스 호출
		return ResponseEntity.ok().build();
	}
	// 공지사항 수정
	@PutMapping("/noticeEdit/{not_postId}")
	public ResponseEntity<NoticeDTO> updateNotice(@PathVariable("not_postId") Integer not_postId, @RequestBody NoticeDTO updatedNoticeDTO) {
	    NoticeDTO updatedNotice = noticeService.updateNotice(not_postId, updatedNoticeDTO);
	    return ResponseEntity.ok(updatedNotice);
	}


	// 공지사항 삭제
	@DeleteMapping("/noticeDetail/{not_postId}")
	public ResponseEntity<Void> delete(@PathVariable("not_postId") Integer not_postId) {
		noticeService.deletePost(not_postId);
		return ResponseEntity.noContent().build();
	}

}
