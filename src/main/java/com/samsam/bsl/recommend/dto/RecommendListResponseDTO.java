package com.samsam.bsl.recommend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendListResponseDTO {
    private String bookImageURL;
    private String postTitle;
    private LocalDateTime createdAt;
}