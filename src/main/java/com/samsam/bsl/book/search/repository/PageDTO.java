package com.samsam.bsl.book.search.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageDTO {
	
	 private int contentCnt;
	    private List<?> content = new ArrayList<>();
	    private int pageSize;
	    private int pageNumber;
	    private int totalPage;

	    public PageDTO(Page<?> pageList) {
	        this.contentCnt = (int) pageList.getTotalElements();
	        this.content = pageList.getContent();
	        this.pageSize = pageList.getSize();
	        this.pageNumber = pageList.getPageable().getPageNumber();
	        this.totalPage = pageList.getTotalPages();

	    }
	
	

}
