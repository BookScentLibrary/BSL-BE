package com.samsam.bsl.notice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_IMAGES")
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class Images {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMAGES_ID")
	private Long Id;

	@Column(nullable = false)
	private String uploadFileName;// ("사용자 지정 파일 이름")

	@Column(nullable = false)
	private String storedFileName;// 저장된 파일 이름

	@Column(nullable = false)
	private String fullPath;// 파일 저장 경로

	private Long size;// 파일 사이즈

	private String extension;// 확장자

	@ManyToOne
	@JoinColumn(name = "not_postId")
	private Notice notice;

	public Images(String uploadFileName, String storedFileName, String fullPath,

			Long size, String extension) {
		this.uploadFileName = uploadFileName;
		this.storedFileName = storedFileName;
		this.fullPath = fullPath;
		this.size = size;
		this.extension = extension;
	}

	public void setNotice (Notice notice) {
	this.notice = notice;
	if(!notice.getUpload Images().contains(this)) {
		notice.getUploadImages().add(this);
		}
	}
}
