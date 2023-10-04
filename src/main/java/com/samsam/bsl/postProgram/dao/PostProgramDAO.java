package com.samsam.bsl.postProgram.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.samsam.bsl.postProgram.service.PostProgramService;

public class PostProgramDAO {
	@Autowired
	private PostProgramService postProgramService;
	@Autowired
	PostProgramDTO postProgramDTO;
	public List<PostProgramDTO> selectPosts() {
		
	}
}
