package com.samsam.bsl.postProgram.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostProgramDTO {
	private String userId;
	private int pro_postId;
	private String content;
	private String postTitle;
	private int userNo;
	private String createAt;
	private String modifiedAt;
	private String postImgURL;
	private String target;
	private String startDate;
	private String endDate;
	private String charge;
	private String phone;
	private int extraGuest;
	private int programStatus;
	
	@Builder
	
	public PostProgramDTO(String userId, int pro_postId, String content, String postTitle, int userNo, String createAt,
			String modifiedAt, String postImgURL, String target, String startDate, String endDate, String charge,
			String phone, int extraGuest, int programStatus) {
		super();
		this.userId = userId;
		this.pro_postId = pro_postId;
		this.content = content;
		this.postTitle = postTitle;
		this.userNo = userNo;
		this.createAt = createAt;
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