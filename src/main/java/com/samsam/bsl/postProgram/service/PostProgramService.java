package com.samsam.bsl.postProgram.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.samsam.bsl.postProgram.model.Program;
import com.samsam.bsl.postProgram.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.samsam.bsl.book.review.dto.ReviewDTO;
import com.samsam.bsl.book.review.model.Review;
import com.samsam.bsl.postProgram.dto.PostProgramDTO;



@Service
public class PostProgramService {

	@Autowired
	private ProgramRepository programRepository;
	private static final int BLOCK_PAGE_NUM_COUNT = 9; // 블럭에 존재하는 페이지 번호 수
	private static final int PAGE_POST_COUNT = 6; // 한 페이지에 존재하는 게시글 수

	 private PostProgramDTO convertEntityToDto(Program program) {

				return PostProgramDTO.builder()
						.userId(program.getUserId())
						.pro_postId(program.getPro_postId())
						.content(program.getContent())
						.postTitle(program.getPostTitle())
						.createdAt(program.getCreatedAt())
						.modifiedAt(program.getModifiedAt())
						.postImgURL(program.getPostImgURL())
						.target(program.getTarget())
						.endDate(program.getEndDate())
						.charge(program.getCharge())
						.deadlineStartDate(program.getDeadlineStartDate())
						.deadlineEndDate(program.getDeadlineStartDate())
						.phone(program.getPhone())
						.extraGuests(program.getExtraGuests())
						.programGuest(program.getProgramGuest())
						.programStatus(program.getProgramStatus())
						.build();
	     			}

//	 	@Transactional
//	 	public Long savePost(PostProgramDTO programDTO) {
//	        return programRepository.save(programDTO.toEntity().getPro_postId());
//	    }
	 	@Transactional
	    public List<PostProgramDTO> getAllProgram(Integer pageNum, int perPage, String sortBy) {
	        Page<Program> page = programRepository.findAll(PageRequest.of(
	                pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdAt")));
	        List<Program> programs = programRepository.findAll();
	        List<PostProgramDTO> programList = new ArrayList<>();

	        for (Program program: programs) {
	            programList.add(this.convertEntityToDto(program));
	        }

	        return programList;
	    }
	 	
		@Transactional
		public List<PostProgramDTO> getProgramList() {
			List<Program> programs = programRepository.findAll();
			List<PostProgramDTO> reviewDTOList = new ArrayList<>();
			for (Program program : programs) {
				reviewDTOList.add(this.convertEntityToDto(program));
			}

			return reviewDTOList;
		}
	 	

	 	
	 	@Transactional
	 	public Integer savePost(PostProgramDTO programDTO) {
	 		return (programRepository.save(programDTO.toEntity()).getPro_postId());
	 		
	 	}

	 	public List<PostProgramDTO> getProgramPerPage(int perPage, int pageNum, String sortBy) {
			Pageable pageable = PageRequest.of(pageNum - 1, perPage, Sort.by(Sort.Direction.ASC, "createdAt"));
			Page<Program> page = programRepository.findAll(pageable);
			List<PostProgramDTO> programs = page.map(this::convertEntityToDto).getContent();
			return programs;
		}
	 	
	 	@Transactional
		public PostProgramDTO getPost(Integer pro_postId) {
			Optional<Program> programWrapper = programRepository.findById(pro_postId);
			Program program = programWrapper.get();

			return this.convertEntityToDto(program);
		}

//	 	public PostProgramDTO getPost(Integer pro_postId) {
//	        // Optional : NPE(NullPointerException) 방지
//	        Optional<Program> programWrapper = programRepository.findById(pro_postId);
//	        Program programs = programWrapper.get();

//	        Program program = Program.builder()
//					.userId(program.getUserId())
//					.pro_postId(program.getPro_postId())
//					.content(program.getContent())
//					.postTitle(program.getPostTitle())
//					.createdAt(program.getCreatedAt())
//					.modifiedAt(program.getModifiedAt())
//					.postImgURL(program.getPostImgURL())
//					.target(program.getTarget())
//					.startDate(program.getStartDate())
//					.endDate(program.getEndDate())
//					.charge(program.getCharge())
//					.phone(program.getPhone())
//					.extraGuest(program.getExtraGuest())
//					.programGuest(program.getProgramGuest())
//					.deadlineStartDate(program.getDeadlineStartDate())
//					.deadlineEndDate(program.getDeadlineEndDate())
//					.programStatus(program.getProgramStatus())
//					.build();
//
//	        return program;
//	    }

	 	//삭제
	     @Transactional
	     public void deletePost(Integer pro_postId) {
	         programRepository.deleteById(pro_postId);
	     }
	     
	     //검색
	     @Transactional
	     public List<PostProgramDTO> searchPosts(String keyword) {
	         List<Program> programEntities = programRepository.findByPostTitleContaining(keyword);
	         List<PostProgramDTO> programList= new ArrayList<>();

	         if (programEntities.isEmpty()) return programList;

	         for (Program program : programEntities) {
	             programList.add(this.convertEntityToDto(program));
	         }

	         return programList;
	     }
	     
	     public List<PostProgramDTO> searchPrograms(String keyword, String searchType) {
	         // 검색 결과를 저장할 리스트
	         List<Program> searchResults = new ArrayList<>();

	         if ("all".equals(searchType)) {
	        	 searchResults = programRepository
		 					.findByPostTitleContainingOrPlaceContaining(keyword, keyword);  
		 		} else if ("postTitle".equals(searchType)) {
		 			searchResults = programRepository.findByPostTitleContaining(keyword);
		 		} else if ("place".equals(searchType)) {
		 			searchResults = programRepository.findByPlaceContaining(keyword);
		 		}

		 		return searchResults.stream().map(this::convertEntityToDto).collect(Collectors.toList());
		 	}
	   

	     //페이징
	     @Transactional
	     public Long getProgramCount() {
	         return programRepository.count();
	     }

	     public Integer[] getPageList(Integer curPageNum, Integer totalLastPageNum) {

	    	 	Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

	    	    Integer blockLastPageNum = Math.min(curPageNum + BLOCK_PAGE_NUM_COUNT, totalLastPageNum);

	    	    curPageNum = Math.max(1, curPageNum - 2);

	    	    for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
	    	        pageList[idx] = val;
	    	    }

	    	    return pageList;
	    	}


		

}