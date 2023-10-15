package com.samsam.bsl.notice.dto;

import javax.persistence.Column;

import com.samsam.bsl.notice.domain.Images;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImagesDTO {
	private Long not_imgId;
	private String origImgName;
	private String storedImgName;
	private String imgPath;
	
	public Images toEntity() {
		Images build = Images.builder()
                .not_imgId(not_imgId)
                .origImgName(origImgName)
                .storedImgName(storedImgName)
                .imgPath(imgPath)
                .build();
        return build;
    }

	@Builder
    public ImagesDTO(Long not_imgId, String origImgName, String storedImgName, String imgPath) {
        this.not_imgId = not_imgId;
        this.origImgName = origImgName;
        this.storedImgName = storedImgName;
        this.imgPath = imgPath;
    }
}
