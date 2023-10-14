package com.samsam.bsl.postProgram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.samsam.bsl.postProgram.dto.PostProgramDTO;
import com.samsam.bsl.postProgram.model.Program;

public interface ProgramRepository extends JpaRepository<Program , Integer>{
	
	@Query("SELECT p FROM Program p ")

	List<Program> findAll();
	
	List<Program> findByPostTitleContainingOrPlaceContaining(String postTitle, String place);  
	
	List<Program> findByPostTitleContaining(String postTitle);  

	List<Program> findByPlaceContaining(String place);

	
//	List<Program> findByTargetContaining(String target);

	
	
}
