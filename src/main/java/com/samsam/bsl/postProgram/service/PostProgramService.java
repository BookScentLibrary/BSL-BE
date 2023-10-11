//package com.samsam.bsl.postProgram.service;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import javax.transaction.Transactional;
//
//import com.samsam.bsl.postProgram.model.Program;
//import com.samsam.bsl.postProgram.repository.ProgramRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import com.samsam.bsl.postProgram.dto.PostProgramDTO;
//
//
//
//@Service
//public class PostProgramService {
//
//	@Autowired
//	private ProgramRepository programRepository;
//	private static final int BLOCK_PAGE_NUM_COUNT = 9; // 블럭에 존재하는 페이지 번호 수
//	private static final int PAGE_POST_COUNT = 6; // 한 페이지에 존재하는 게시글 수
//
//	 private PostProgramDTO convertEntityToDto(Program program) {
//
//				return PostProgramDTO.builder()
//						.userId(program.getUserId())
//						.pro_postId(program.getPro_postId())
//						.content(program.getContent())
//						.postTitle(program.getPostTitle())
//						.userNo(program.getUserNo())
//						.createdAt(program.getCreatedAt())
//						.modifiedAt(program.getModifiedAt())
//						.postImgURL(program.getPostImgURL())
//						.target(program.getTarget())
//						.startDate(program.getStartDate())
//						.endDate(program.getEndDate())
//						.charge(program.getCharge())
//						.phone(program.getPhone())
//						.extraGuest(program.getExtraGuests())
//						.programStatus(program.getProgramstatus())
//						.build();
//	     			}
//
////	 	@Transactional
////	 	public Long savePost(PostProgramDTO programDTO) {
////	        return programRepository.save(programDTO.toEntity().getPro_postId());
////	    }
//	 	@Transactional
//	    public List<PostProgramDTO> findAll(Integer pageNum, int perPage, String sortBy) {
//	        Page<Program> page = programRepository.findAll(PageRequest.of(
//	                pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdAt")));
//
//	        List<Program> programEntities = page.getContent();
//	        List<PostProgramDTO> programList = new ArrayList<>();
//
//	        for (Program program: programEntities) {
//	            programList.add(this.convertEntityToDto(program));
//	        }
//
//	        return programList;
//	    }
//
//	 	@Transactional
//		public Integer savePost(PostProgramDTO programDTO) {
//			return ((PostProgramDTO) programRepository.save(programDTO.toEntity())).getPro_postId();
//		}
//
//	 	public List<PostProgramDTO> getProgramPerPage(int perPage, int pageNum, String sortBy) {
//			Pageable pageable = PageRequest.of(pageNum - 1, perPage, Sort.by(Sort.Direction.ASC, "createdAt"));
//			Page<Program> page = programRepository.findAll(pageable);
//			List<PostProgramDTO> programs = page.map(this::convertEntityToDto).getContent();
//			return programs;
//		}
//	 	public PostProgramDTO getPost(Integer pro_postId) {
//	        // Optional : NPE(NullPointerException) 방지
//	        Optional<Program> programWrapper = programRepository.findById(pro_postId);
//	        Program program = programWrapper.get();
//
//	        PostProgramDTO postProgramDTO = PostProgramDTO.builder()
//					.userId(program.getUserId())
//					.pro_postId(program.getPro_postId())
//					.content(program.getContent())
//					.postTitle(program.getPostTitle())
//					.userNo(program.getUserNo())
//					.createdAt(program.getCreatedAt())
//					.modifiedAt(program.getModifiedAt())
//					.postImgURL(program.getPostImgURL())
//					.target(program.getTarget())
//					.startDate(program.getStartDate())
//					.endDate(program.getEndDate())
//					.charge(program.getCharge())
//					.phone(program.getPhone())
//					.extraGuest(program.getExtraGuests())
//					.programStatus(program.getProgramstatus())
//					.build();
//
//	        return postProgramDTO;
//	    }
//
//
//	     @Transactional
//	     public void deletePost(Integer pro_postId) {
//	         programRepository.deleteById(pro_postId);
//	     }
//
//	     @Transactional
//	     public List<PostProgramDTO> searchPosts(String keyword) {
//	         List<Program> programEntities = programRepository.findByPostTitleContaining(keyword);
//	         List<PostProgramDTO> programList= new ArrayList<>();
//
//	         if (programEntities.isEmpty()) return programList;
//
//	         for (Program program : programEntities) {
//	             programList.add(this.convertEntityToDto(program));
//	         }
//
//	         return programList;
//	     }
//
//	     //페이징
//	     @Transactional
//	     public Long getProgramCount() {
//	         return programRepository.count();
//	     }
//
//	     public Integer[] getPageList(Integer curPageNum, Integer totalLastPageNum) {
//
//	    	 	Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];
//
//	    	    Integer blockLastPageNum = Math.min(curPageNum + BLOCK_PAGE_NUM_COUNT, totalLastPageNum);
//
//	    	    curPageNum = Math.max(1, curPageNum - 2);
//
//	    	    for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
//	    	        pageList[idx] = val;
//	    	    }
//
//	    	    return pageList;
//	    	}
//
//	     @Transactional
//	     public List<PostProgramDTO> searchPrograms(String keyword, String searchType){
//	    	 List<Program> programs = new ArrayList<>();
//
//	    	 if ("".equals(searchType)) {
//	    		 programs = programRepository.findByPostTitleContainingOrContentContaining(
//	    				 keyword,keyword);
//	    	 }else if("postTitle".equals(searchType)) {
//	    		 programs = programRepository.findByPostTitleContaining(keyword);
//	    	 }else if("contenet".equals(searchType)) {
//	    		 programs = programRepository.findByContentContaining(keyword);
//
//
//	 	}
//	    	 return programs.stream().map(this::convertEntityToDto).collect(Collectors.toList());
//
//
//	     }
//
//}