package com.samsam.bsl.program.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.samsam.bsl.postProgram.dto.PostProgramDTO;
import com.samsam.bsl.program.model.Program;

public interface ProgramRepository extends JpaRepository<Program , Integer>{
	
	 @Query(value = "select p from Program p")
	 
	    List<Program> findAll();

	    List<Program> findByPostTitleContainingOrContentContaining(String postTitle, String content);
	    
	    List<Program> findByPostTitleContaining(String title);
	    
	    List<Program> findByContentContaining(String content);

		List<Program> save(PostProgramDTO entity);

}
