package com.samsam.bsl.postProgram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.postProgram.dao.PostProgramDAO;
import com.samsam.bsl.postProgram.dto.PostProgramDTO;
import com.samsam.bsl.postProgram.service.PostProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/postProgram")
@RequiredArgsConstructor
public class PostProgramController {
	
	PostProgramDTO postProgramDTO;
	
	@Autowired
	private final PostProgramService postProgramService;

		@GetMapping("/listupPost")
		public String listupPost(Model model) {
			System.out.println("[PostProgramController] listupPost()");
			
			String nextPage = "/listupPosts";
			
			List<PostProgramDTO> postProgramDTOs = postProgramService.listupPost();
			
			model.addAttribute("postProgramDTOs", postProgramDTOs);
			
			return nextPage;
			
		}
		
		@PostMapping("/registerForm")
		public String registerForm() {
			System.out.println("[PostProgramDAO] registerForm()");
			
			String nextPage = "postProgram/register_post_Form";
			
			return nextPage;
			
		}
		
		@GetMapping("/registerConfirm")
		public String registerConfirm() {
			System.out.println("[PostProgramDAO] registerForm()");
			
			String nextPage ="post/program/register_post_ok";
			return nextPage;
		}

	
}
