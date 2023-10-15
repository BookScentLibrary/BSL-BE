package com.samsam.bsl.recommend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendDetailResponseDTO {
	private int recPostId;
    private String bookImageURL;
    private String bookname;
    private String author;
    private int bookNo;
    private String publisher;
    private String publicationYear;
    private String postTitle;
    private String content; // 게시글 내용
    private LocalDateTime createdAt;
    private String userId;
    private String callNum;
    private String shelfarea;
    
}
