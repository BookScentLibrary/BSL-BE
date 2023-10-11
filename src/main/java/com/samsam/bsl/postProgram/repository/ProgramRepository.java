package com.samsam.bsl.postProgram.repository;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.samsam.bsl.postProgram.model.Program;

public interface ProgramRepository extends JpaRepository<Program , Integer>{

//	List<Program> getAllProgram();
//	Page<Program> findAllByTitleContainsAndUserUserRoleNot( String title, PageRequest pageRequest); //검색기능
//	Page<Program> findAllByTargetContainsAndUserUserRoleNot( String title, PageRequest pageRequest); //검색기능
//	Page<Program> findAllByContentContainsAndUserUserRoleNot( String title, PageRequest pageRequest); //검색기능
}
