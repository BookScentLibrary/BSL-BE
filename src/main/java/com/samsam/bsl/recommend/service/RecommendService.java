package com.samsam.bsl.recommend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.recommend.repository.RecommendRepository;
import com.samsam.bsl.user.dto.ResponseDTO;
import com.samsam.bsl.user.entity.UserEntity;
import com.samsam.bsl.user.repository.UserRepository;

@Service
public class RecommendService {

	@Autowired
	RecommendRepository recommendRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	// 게시글 작성
	public ResponseDTO<?> saveRecommend(RecommendRequestDTO dto) {
		System.out.println("RecommendRequestDTO : " + dto);
		Recommend recommend = new Recommend(dto);
		System.out.println("recommend : " + recommend);
		try {
			// 사용자 정보 가져오기
			UserEntity user = userRepository.findByUserId(dto.getUserId());

			// 책 정보 가져오기
			Book book = bookRepository.getBook(dto.getBookNo());

			// 추천 게시글 작성
			recommend.setUserId(user.getUserId());
			System.out.println(recommend.getUser());
			recommend.setBookNo(book.getBookNo());
			System.out.println(recommend.getBook());
			// RecommendRepository를 이용해서 데이터베이스에 Entity 저장
			recommendRepository.save(recommend);
			System.out.println("recommend 성공: " + recommend);
			// 성공시 success response반환
			return ResponseDTO.setSuccess("게시글 작성 성공", null);
		} catch (Exception e) {
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
		// 실패 시 에러 response 반환
		// return ResponseDTO.setFailed("게시글 작성 실패");
	}
	
//	//게시글 목록
//	public ResponseDTO<?> saveRecommend() {
//		try {
//			List<Recommend> recommendList = recommendRepository.findAll();
//		
//			// 사용자 정보 가져오기
//						UserEntity user = userRepository.findByUserId(dto.getUserId());
//
//						// 책 정보 가져오기
//						Book book = bookRepository.getBook(dto.getBookNo());
//		}
//	}

}
