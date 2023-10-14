package com.samsam.bsl.postProgram.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.samsam.bsl.postProgram.dto.PostProgramDTO.PostProgramDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table(name="post_program")
public class Program {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =false)
	private Integer pro_postId;
	
	
	@Column(length = 40, nullable = false)
	private String userId;
	
	@Column(length = 40, nullable = false)
	private String postTitle;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String content;

	@Column(length = 40, nullable = true)
	private String place;
	
	
	@Column(name="createdAt")
	@CreatedDate
	private String createdAt;
	
	@Column(name="modifiedAt")
	@CreatedDate
	@LastModifiedDate
	private String modifiedAt;

	@Column(name="startDate")
	@CreatedDate
	@LastModifiedDate
	private String startDate;
	
	@Column(name="endDate")
	@CreatedDate
	@LastModifiedDate
	private String endDate;
	
	
	@PrePersist
	public void onPrePersist() {
		this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		this.modifiedAt = this.createdAt;
	}
	
	@PreUpdate
	public void onPreUpdate() {
		this.modifiedAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
	}

	
//	@Temporal(TemporalType.DATE) java.util.Date startDate;
//	@Temporal(TemporalType.DATE) java.util.Date endDate;
	
	@Column(length = 100, nullable = true)
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
	private int programstatus;


	public static Program builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
