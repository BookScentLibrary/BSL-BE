package com.samsam.bsl.recommend.dto;

import com.samsam.bsl.recommend.model.Recommend;
import com.samsam.bsl.book.rent.domain.Book; // 도서 정보를 가져올 클래스
import com.samsam.bsl.user.entity.UserEntity; // 사용자 정보를 가져올 클래스

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendListResponseDTO {
    private String bookImageURL;
    private Recommend recommend;
    private Book book; // 도서 정보를 담을 필드
    private UserEntity user; // 사용자 정보를 담을 필드
}