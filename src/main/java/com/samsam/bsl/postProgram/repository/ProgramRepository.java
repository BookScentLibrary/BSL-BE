package com.samsam.bsl.postProgram.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.samsam.bsl.postProgram.model.Program;

public interface ProgramRepository extends JpaRepository<Program , Integer>{
	
	@Query("SELECT p FROM Program p ") //이게 문제인건가..

	List<Program> findAll();
	
	Page<Program> findByPostTitleContainingOrPlaceContaining(String postTitle,String place, Pageable pageable);  
	
	List<Program> findByPostTitleContaining(String postTitle);  

	List<Program> findByPlaceContaining(String place);

	List<Program> findByPostTitleContainingOrPlaceContaining(String keyword, String keyword2);

	
//	List<Program> findByTargetContaining(String target);

	
	
}
