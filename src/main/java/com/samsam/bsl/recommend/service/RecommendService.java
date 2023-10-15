package com.samsam.bsl.recommend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.repository.BookRepository;
import com.samsam.bsl.recommend.dto.RecommendDetailResponseDTO;
import com.samsam.bsl.recommend.dto.RecommendListResponseDTO;
import com.samsam.bsl.recommend.dto.RecommendRequestDTO;
import com.samsam.bsl.recommend.dto.RecommendUpdateRequestDTO;
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
		Recommend recommend = new Recommend(dto);
		try {
			// RecommendRepository를 이용해서 데이터베이스에 Entity 저장
			recommendRepository.save(recommend);
			return ResponseDTO.setSuccess("게시글 작성 성공", null);
		} catch (Exception e) {
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

	// 게시글 목록
	public ResponseDTO<List<RecommendListResponseDTO>> getRecommendList() {
		try {
			List<Recommend> recommendList = recommendRepository.findAll();
			List<RecommendListResponseDTO> responseList = new ArrayList<>(); // 리스트 생성

			for (Recommend recommend : recommendList) {
				int bookNo = recommend.getBookNo();

				// 도서 정보 가져오기
				Book book = bookRepository.getBook(bookNo);

				// RecommendListResponseDTO 객체 생성
				RecommendListResponseDTO recommendListResponseDTO = new RecommendListResponseDTO();
				recommendListResponseDTO.setBookImageURL(book.getBookImageURL());
				recommendListResponseDTO.setPostTitle(recommend.getPostTitle());
				recommendListResponseDTO.setCreatedAt(recommend.getCreatedAt());
				recommendListResponseDTO.setRecPostId(recommend.getRecPostId());
				responseList.add(recommendListResponseDTO); // 리스트에 객체 추가
			}

			return ResponseDTO.setSuccess("게시글 조회 성공", responseList);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

	// 사서 추천 도서 상세보기
	public ResponseDTO<RecommendDetailResponseDTO> getPost(int recPostId) {
		try {
			Optional<Recommend> recommendWrapper = recommendRepository.findById(recPostId);
			Recommend recommend = recommendWrapper.get();

			// 도서 정보 가져오기
			Book book = bookRepository.getBook(recommend.getBookNo());

			RecommendDetailResponseDTO recommendDetailResponseDTO = new RecommendDetailResponseDTO();
			recommendDetailResponseDTO.setAuthor(book.getAuthor());
			recommendDetailResponseDTO.setBookImageURL(book.getBookImageURL());
			recommendDetailResponseDTO.setBookname(book.getBookname());
			recommendDetailResponseDTO.setContent(recommend.getContent());
			recommendDetailResponseDTO.setCreatedAt(recommend.getCreatedAt());
			recommendDetailResponseDTO.setPostTitle(recommend.getPostTitle());
			recommendDetailResponseDTO.setPublicationYear(book.getPublicationYear());
			recommendDetailResponseDTO.setPublisher(book.getPublisher());
			recommendDetailResponseDTO.setBookNo(book.getBookNo());
			recommendDetailResponseDTO.setRecPostId(recommend.getRecPostId());
			recommendDetailResponseDTO.setUserId(recommend.getUserId());
			recommendDetailResponseDTO.setShelfarea(book.getShelfArea());
			recommendDetailResponseDTO.setCallNum(book.getCallNum());

			return ResponseDTO.setSuccess("게시글 조회 성공", recommendDetailResponseDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

	// 사서 추천 도서 게시글 수정
	@Transactional
	public ResponseDTO<?> updateRecommend(int recPostId, RecommendUpdateRequestDTO recommendUpdateRequestDTO) {
		try {
			Optional<Recommend> recommendWrapper = recommendRepository.findById(recPostId);
			Recommend recommend = recommendWrapper.get();
			recommend.update(recommendUpdateRequestDTO);
			return ResponseDTO.setSuccess("게시글 수정 성공", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

	// 사서 추천 도서 게시글 삭제
	public ResponseDTO<?> deleteRecommend(int recPostId) {
		try {
			recommendRepository.deleteById(recPostId);
			return ResponseDTO.setSuccess("게시글 삭제 성공", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDTO.setFailed("데이터베이스 오류입니다.");
		}
	}

}
