package com.samsam.bsl.postProgram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.samsam.bsl.postProgram.model.Program;

public interface ProgramRepository extends JpaRepository<Program , Integer>{
	
//	@Query("SELECT p FROM Program p ")

	List<Program> findAll();
	
	List<Program> findByPostTitleContainingOrContentContaining(String Title, String Content);  
	
	List<Program> findByPostTitleContaining(String postTitle);  

	List<Program> findByContentContaining(String content);  
	
//	List<Program> findByTargetContaining(String target);

	
	
}
