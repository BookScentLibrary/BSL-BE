package com.samsam.bsl.recommend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.recommend.repository.RecommendRepository;
import com.samsam.bsl.user.dto.ResponseDTO;

@Service
public class RecommendService {
	
	@Autowired RecommendRepository recommendRepository;
	
	//게시글 작성
    public ResponseDTO<?> saveRecommendation(RecommendRequestDTO dto) {
        Recommend recommend = new Recommend(dto);
		try {
			// RecommendRepository를 이용해서 데이터베이스에 Entity 저장
			recommendRepository.save(recommend);
			// 성공시 success response반환
			return ResponseDTO.setSuccess("게시글 작성 성공", null);
		} catch (Exception e) {
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	// 실패 시 에러 response 반환
    //return ResponseDTO.setFailed("게시글 작성 실패");
    }
	
	


}
