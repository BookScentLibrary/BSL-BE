package com.samsam.bsl.book.review.dto;

import com.samsam.bsl.book.review.domain.RatingData;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RatingDataDTO {

	private int bookNo;
	private int point_1;
	private int point_2;
	private int point_3;
	private int point_4;
	private int point_5;

	// NoticeDTO -> Notice
	public RatingData toEntity() {
		RatingData ratingData = RatingData.builder().bookNo(bookNo).point_1(point_1).point_2(point_2).point_3(point_3)
				.point_4(point_4).point_5(point_5).build();
		return ratingData;
	}

	@Builder
	public RatingDataDTO(int bookNo, int point_1, int point_2, int point_3, int point_4, int point_5) {
		this.bookNo = bookNo;
		this.point_1 = point_1;
		this.point_2 = point_2;
		this.point_3 = point_3;
		this.point_4 = point_4;
		this.point_5 = point_5;
	}
}
