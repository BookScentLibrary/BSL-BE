package com.samsam.bsl.postProgram.dao;

import java.util.List;

import com.samsam.bsl.postProgram.dto.PostProgramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.samsam.bsl.postProgram.service.PostProgramService;
import org.springframework.stereotype.Repository;

@Repository
public class PostProgramDAO {

	@Autowired
	private PostProgramService postProgramService;

	public List<PostProgramDTO> selectPosts() {
		return null;
	}
}
