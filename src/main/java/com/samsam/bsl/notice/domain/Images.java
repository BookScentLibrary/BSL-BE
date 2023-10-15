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
@Table(name = "notice_images")
@Getter
@NoArgsConstructor
public class Images {
	@Id
	@GeneratedValue
	private Long not_imgId;

	@Column(nullable = false)
	private String origImgName;// ("사용자 지정 파일 이름")

	@Column(nullable = false)
	private String storedImgName;// 저장된 파일 이름

	@Column(nullable = false)
	private String imgPath;// 파일 저장 경로

//	@ManyToOne
//	@JoinColumn(name = "not_postId")
//	private Notice notice;

	@Builder
    public Images(Long not_imgId, String origImgName, String storedImgName, String imgPath) {
        this.not_imgId = not_imgId;
        this.origImgName = origImgName;
        this.storedImgName = storedImgName;
        this.imgPath = imgPath;
    }
}
