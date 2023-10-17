package com.samsam.bsl.notice.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsam.bsl.notice.domain.Images;
import com.samsam.bsl.notice.dto.ImagesDTO;
import com.samsam.bsl.notice.repository.ImagesRepository;

@Service
public class ImagesService {
	private ImagesRepository imagesRepository;
	private String uploadPath;  // 이미지 업로드 경로

	public ImagesService(ImagesRepository imagesRepository) {
		this.imagesRepository = imagesRepository;
		//this.uploadPath = "경로를 여기에 입력하세요";  // 실제 파일 업로드 경로로 수정 필요
	}

	@Transactional
	public Long saveImage(ImagesDTO imagesDTO) {
		return imagesRepository.save(imagesDTO.toEntity()).getNot_imgId();
	}
	
//	@Transactional
//    public int saveImage(ImagesDTO imagesDTO) throws IOException {
//        // 파일 업로드 및 저장
//        String origImgName = imagesDTO.getOrigImgName();
//        String storedImgName = imagesDTO.getStoredImgName();
//        String imgPath = imagesDTO.getImgPath();
//        
//        File destination = new File(uploadPath, storedImgName);
//
//        // 파일 저장
//        if (!destination.getParentFile().exists()) {
//            destination.getParentFile().mkdirs();
//        }
//        
//        // 이미지 파일 복사
//        imagesDTO.getImgPath().transferTo(destination);
//
//        // 데이터베이스에 이미지 정보 저장
//        Images image = Images.builder()
//                .origImgName(origImgName)
//                .storedImgName(storedImgName)
//                .imgPath(destination.getAbsolutePath())
//                .build();
//
//        Images savedImage = imagesRepository.save(image);
//
//        return savedImage.getNot_imgId();
//    }

	@Transactional
	public ImagesDTO getImage(Long not_imgId) {
		Images images = imagesRepository.findById(not_imgId).get();

		ImagesDTO imagesDTO = ImagesDTO.builder()
				.not_imgId(not_imgId)
				.origImgName(images.getOrigImgName())
				.storedImgName(images.getStoredImgName())
				.imgPath(images.getImgPath()).build();
		return imagesDTO;
	}
	
	
}
