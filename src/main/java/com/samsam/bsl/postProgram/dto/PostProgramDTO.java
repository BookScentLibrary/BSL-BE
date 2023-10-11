package com.samsam.bsl.postProgram.dto;



import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "post_program")
public class PostProgramDTO {
	
	private int userId;
	private int pro_postId;
	private String content;
	private String postTitle;
	private int userNo;
	private String createdAt;
	private String modifiedAt;
	private String postImgURL;
	private String target;
	private String startDate;
	private String endDate;
	private String charge;
	private String phone;
	private int extraGuest;
	private int programStatus;
	

	
	public PostProgramDTO toEntity() {
		return PostProgramDTO.builder()
				.userId(userId)
				.pro_postId(pro_postId)
				.content(content)
				.postTitle(postImgURL)
				.userNo(userNo)
				.createdAt(createdAt)
				.modifiedAt(modifiedAt)
				.postImgURL(postImgURL)
				.target(target)
				.startDate(startDate)
				.endDate(endDate)
				.charge(charge)
				.phone(phone)
				.extraGuest(extraGuest)
				.programStatus(programStatus)
				.build();
	}
	
	@Builder
	public PostProgramDTO(int userId, int pro_postId, String content, String postTitle, int userNo, String createdAt,
			String modifiedAt, String postImgURL, String target, String startDate, String endDate, String charge,
			String phone, int extraGuest, int programStatus) {
		super();
		this.userId = userId;
		this.pro_postId = pro_postId;
		this.content = content;
		this.postTitle = postTitle;
		this.userNo = userNo;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.postImgURL = postImgURL;
		this.target = target;
		this.startDate = startDate;
		this.endDate = endDate;
		this.charge = charge;
		this.phone = phone;
		this.extraGuest = extraGuest;
		this.programStatus = programStatus;
	}
	

	
}