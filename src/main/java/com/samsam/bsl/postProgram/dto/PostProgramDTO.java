package com.samsam.bsl.postProgram.dto;




import javax.persistence.Table;

import com.samsam.bsl.postProgram.model.Program;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "program")
public class PostProgramDTO {
	
	private String userId;
	private int pro_postId;
	private String content;
	private String place;
	private String postTitle;
	private String createdAt;
	private String modifiedAt;
	private String postImgURL;
	private String target;
	private String startDate;
	private String endDate;
	private String charge;
	private String phone;
	private String deadlineStartDate;
	private String deadlineEndDate;
	private int extraGuests;
	private int programGuest;
	private int programStatus;
	

	
	public Program toEntity() {
	 Program program = Program.builder()
				.userId(userId)
				.pro_postId(pro_postId)
				.content(content)
				.place(place)
				.postTitle(postImgURL)
				.createdAt(createdAt)
				.modifiedAt(modifiedAt)
				.postImgURL(postImgURL)
				.target(target)
				.startDate(startDate)
				.endDate(endDate)
				.charge(charge)
				.deadlineStartDate(deadlineStartDate)
				.deadlineEndDate(deadlineStartDate)
				.phone(phone)
				.extraGuests(extraGuests)
				.programGuest(programGuest)
				.programStatus(programStatus)
				.build();
	 	return program;
	}



	@Builder
	public PostProgramDTO(String userId, int pro_postId, String content, String place, String postTitle,
			String createdAt, String modifiedAt, String postImgURL, String target, String startDate, String endDate,
			String charge, String phone, String deadlineStartDate, String deadlineEndDate, int extraGuests,
			int programGuest, int programStatus) {
		super();
		this.userId = userId;
		this.pro_postId = pro_postId;
		this.content = content;
		this.place = place;
		this.postTitle = postTitle;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.postImgURL = postImgURL;
		this.target = target;
		this.startDate = startDate;
		this.endDate = endDate;
		this.charge = charge;
		this.phone = phone;
		this.deadlineStartDate = deadlineStartDate;
		this.deadlineEndDate = deadlineEndDate;
		this.extraGuests = extraGuests;
		this.programGuest = programGuest;
		this.programStatus = programStatus;
	}
	
//	 public PostProgramDTO toEntity() {
//		    return PostProgramDTO.builder()
//		        .userId(userId)
//		        .pro_postId(pro_postId)
//		        .content(content)
//		        .postTitle(postImgURL)
//		        .createdAt(createdAt)
//		        .modifiedAt(modifiedAt)
//		        .postImgURL(postImgURL)
//		        .target(target)
//		        .startDate(startDate)
//		        .endDate(endDate)
//		        .charge(charge)
//		        .phone(phone)
//		        .extraGuest(extraGuest)
//		        .programStatus(programStatus)
//		        .build();
//		  }
	
	



	
	

	
}