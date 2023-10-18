package com.samsam.bsl.postProgram.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;




@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="program")
public class Program {
	
	@Id
	@Column(nullable =false)
	private Integer pro_postId;
	
	@Column(length = 40, nullable = false)
	private String userId;
	
	@Column(length = 40, nullable = false)
	private String postTitle;
	
	@Column(columnDefinition = "TEXT")
	private String content;

	@Column(length = 40, nullable = false)
	String place;
	
	@Column(name="createdAt" , nullable = false)
	@CreatedDate
	private LocalDateTime createdAt;
	
	@Column(name="modifiedAt", nullable = false)
	@CreatedDate
	@LastModifiedDate
	private LocalDateTime modifiedAt;

	@Column(name="startDate", nullable = false)
	private LocalDateTime startDate;
	
	@Column(name="endDate", nullable = false)
	private LocalDateTime endDate;

	@Column(name="deadlineStartDate", nullable = false)
	@CreatedDate
	@LastModifiedDate
	private LocalDateTime deadlineStartDate;
	
	@Column(name="deadlineEndDate", nullable = false)
	@CreatedDate
	@LastModifiedDate
	private LocalDateTime deadlineEndDate;
	
	
//	@PrePersist
//	public void onPrePersist() {
//		this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
//		this.modifiedAt = this.createdAt;
//	}
//	
//	@PreUpdate
//	public void onPreUpdate() {
//		this.modifiedAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
//	}

	
//	@Temporal(TemporalType.DATE) java.util.Date startDate;
//	@Temporal(TemporalType.DATE) java.util.Date endDate;
	
	@Value("${file.dir}/")
	@Column(length = 100)
	private String postImgURL;
	
	@Column(length = 100, nullable = false)
	private String target;
	
	@Column(length = 20, nullable = false)
	private String charge;
	
	@Column(length = 20, nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private Integer extraGuests;
	
	@Column(nullable = false)
	private Integer programGuest;
	
	@Column(nullable = false)
	private int programStatus;


	
}
