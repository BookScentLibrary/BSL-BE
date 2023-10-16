//package com.samsam.bsl.postProgram.Controller;
//
//
//import java.util.List;
//
//import com.samsam.bsl.postProgram.service.PostProgramService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.samsam.bsl.postProgram.dto.PostProgramDTO;
//
//
//@RestController
//@RequestMapping("/news")
//public class PostProgramController {
//
//
//  @Autowired
//  private PostProgramService postProgramService;
//
//
//  //리스트페이지
////	@GetMapping("/programList")
////	public ResponseEntity<List<PostProgramDTO>> getAllProgram(
////		    @RequestParam(defaultValue = "6") @Min(1) int perPage,
////		    @RequestParam(defaultValue = "1") int pageNum,
////		    @RequestParam(defaultValue = "createdAt") @Min(1) String sortBy,
////		    @RequestParam(value = "searchKeyword", required = false) String searchKeyword
////		) {
////		    List<PostProgramDTO> programList;
////
////		    if (searchKeyword != null && !searchKeyword.isEmpty()) {
////		        // If a search keyword is provided, perform a search based on the keyword.
////		        programList = postProgramService.searchPrograms(searchKeyword, sortBy);
////		    } else {
////		        // If no search keyword is provided, retrieve the full list of programs.
////		        programList = postProgramService.findAll(pageNum, perPage, sortBy);
////		    }
////
////		    if (programList.isEmpty()) {
////		        return ResponseEntity.noContent().build(); // Return a 204 No Content response if no programs found
////		    }
////
////		    return ResponseEntity.ok(programList);
////		}
//
//  @GetMapping("/programList")
//  public ResponseEntity<List<PostProgramDTO>> handleProgramListRequest(
//    @RequestParam(value = "keyword", required = false) String keyword,
//    @RequestParam(value = "searchType", defaultValue = "all") String searchType) {
//
//    // keyword 파라미터가 있을 경우 검색 동작을 수행
//    if (keyword != null && !keyword.isEmpty()) {
//      List<PostProgramDTO> programs = postProgramService.searchPrograms(keyword, searchType);
//
//      if (programs.isEmpty()) {
//        return ResponseEntity.noContent().build();
//      } else {
//        return ResponseEntity.ok(programs);
//      }
//    } else {
//      // keyword 파라미터가 없을 경우 모든 리뷰를 불러오는 동작을 수행
//      List<PostProgramDTO> allProgramDTOList = postProgramService.getProgramList();
//
//      if (allProgramDTOList.isEmpty()) {
//        return ResponseEntity.noContent().build();
//      } else {
//        return ResponseEntity.ok(allProgramDTOList);
//      }
//    }
//  }
//
//
//  //작성
//
//
//  //    @PostMapping("/registerForm")
////    public ResponseEntity<Void> write(@RequestBody PostProgramDTO programDTO) {
////        postProgramService.savePost(programDTO);
////        return ResponseEntity.status(HttpStatus.CREATED).build();
////    }
//  @PostMapping("/registerForm")
//  public ResponseEntity<Void> write(@RequestBody PostProgramDTO postProgramDTO) {
//    postProgramService.savePost(postProgramDTO);
//    return ResponseEntity.status(HttpStatus.CREATED).build();
//  }
//
//
//  //삭제
//  @DeleteMapping("/news/ProgramDelete/{pro_postId}/")
//  public ResponseEntity<Void> delete(@PathVariable("pro_postId") Integer pro_postId) {
//
//    postProgramService.deletePost(pro_postId);
//    return ResponseEntity.noContent().build();
//  }
//
//  @GetMapping("/programDetail/{pro_postId}")
//  public ResponseEntity<PostProgramDTO> detail(@PathVariable("pro_postId") Integer pro_postId) {
//    PostProgramDTO programDTO = postProgramService.getPost(pro_postId);
//    return ResponseEntity.ok(programDTO);
//  }
//
//
//  //검색
//
//  public ResponseEntity<List<PostProgramDTO>> searchPrograms(
//    @RequestParam(value = "keyword", required = false) String keyword,
//    @RequestParam(value = "searchType", defaultValue = "") String searchType) {
//
//    // Validate searchType (optional)
//    if (!isValidSearchType(searchType)) {
//      return ResponseEntity.badRequest().build(); // Return a 400 Bad Request response for invalid searchType
//    }
//
//    // Perform the search based on the provided keyword and searchType
//    List<PostProgramDTO> ProgramList = postProgramService.searchPrograms(keyword, searchType);
//
//    if (ProgramList.isEmpty()) {
//      return ResponseEntity.noContent().build(); // Return a 204 No Content response if no results found
//    }
//
//    return ResponseEntity.ok(ProgramList);
//  }
//
//  private boolean isValidSearchType(String searchType) {
//    return true;
//  }
//
//}
