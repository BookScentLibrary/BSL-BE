package com.samsam.bsl.postProgram.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.samsam.bsl.postProgram.dao.PostProgramDAO;
import com.samsam.bsl.postProgram.dto.PostProgramDTO;

@Service
public class PostProgramService {
	
	private PostProgramDAO postProgramDAO;
	public List<PostProgramDTO> listupPost() {
		System.out.println("[PostProgramService] listupPost()");
		return postProgramDAO.selectPrograms();
	}
}
