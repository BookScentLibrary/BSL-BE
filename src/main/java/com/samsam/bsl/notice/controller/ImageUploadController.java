//package com.samsam.bsl.notice.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/images")
//public class ImageUploadController {
//	@Value("${file.upload-dir}") // application.properties 또는 application.yml에서 설정한 경로
//    private String uploadDir;
//
//    @PostMapping("/{username}/thumbnail")
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
//}
