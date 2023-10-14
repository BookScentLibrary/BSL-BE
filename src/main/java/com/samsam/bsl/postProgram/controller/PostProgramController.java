package com.samsam.bsl.postProgram.Controller;



import java.util.List;

import javax.validation.constraints.Min;

import com.samsam.bsl.postProgram.service.PostProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsam.bsl.postProgram.dto.PostProgramDTO;


@RestController
@RequestMapping("/news")
public class PostProgramController {


	@Autowired
	private PostProgramService postProgramService;


	//리스트페이지
	@GetMapping("/programList")
	public ResponseEntity<List<PostProgramDTO>> getAllProgram(
		    @RequestParam(defaultValue = "6") @Min(1) int perPage,
		    @RequestParam(defaultValue = "1") int pageNum,
		    @RequestParam(defaultValue = "createdAt") @Min(1) String sortBy,
		    @RequestParam(value = "searchKeyword", required = false) String searchKeyword
		) {
		    List<PostProgramDTO> programList;

		    if (searchKeyword != null && !searchKeyword.isEmpty()) {
		        // If a search keyword is provided, perform a search based on the keyword.
		        programList = postProgramService.searchPrograms(searchKeyword, sortBy);
		    } else {
		        // If no search keyword is provided, retrieve the full list of programs.
		        programList = postProgramService.findAll(pageNum, perPage, sortBy);
		    }

		    if (programList.isEmpty()) {
		        return ResponseEntity.noContent().build(); // Return a 204 No Content response if no programs found
		    }

		    return ResponseEntity.ok(programList);
		}


	//작성


    @PostMapping("/registerForm")
    public ResponseEntity<Void> write(PostProgramDTO programDTO) {
        postProgramService.savePost(programDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


	 //삭제
	 @DeleteMapping("/news/ProgramDelete/{pro_postId}/")
		public ResponseEntity<Void> delete(@PathVariable("pro_postId") Integer pro_postId) {

		 postProgramService.deletePost(pro_postId);
		    return ResponseEntity.noContent().build();
		}
	 
	 @GetMapping("/programDetail/{rev_postId}")
		public ResponseEntity<PostProgramDTO> detail(@PathVariable("pro_postId") Integer pro_postId) {
			PostProgramDTO programDTO = postProgramService.getPost(pro_postId);
			return ResponseEntity.ok(programDTO);
		}


	 //검색
	 
	 public ResponseEntity<List<PostProgramDTO>> searchPrograms(
	     @RequestParam(value = "keyword", required = false) String keyword,
	     @RequestParam(value = "searchType", defaultValue = "") String searchType) {

	     // Validate searchType (optional)
	     if (!isValidSearchType(searchType)) {
	         return ResponseEntity.badRequest().build(); // Return a 400 Bad Request response for invalid searchType
	     }

	     // Perform the search based on the provided keyword and searchType
	     List<PostProgramDTO> ProgramList = postProgramService.searchPrograms(keyword, searchType);

	     if (ProgramList.isEmpty()) {
	         return ResponseEntity.noContent().build(); // Return a 204 No Content response if no results found
	     }

	     return ResponseEntity.ok(ProgramList);
	 }

	 private boolean isValidSearchType(String searchType) {
	     return true;
	 }

}