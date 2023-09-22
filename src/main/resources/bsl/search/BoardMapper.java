package bsl.search;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.samsam.bsl.search.VO.BoardVO;

@Mapper
public abstract class BoardMapper {

	
	//전달된 키워드를 가지고 데이터를 조회하는 api 작성
	@Select("SELECT * FROM books WHERE bookNo=${bookNo}")
	abstract
	//임의로 메서드를 만들어 놓음. 나중에 추가해야 함. 책 번호로 책을 호출하는 부분
	BoardVO getboardVO (@Param("bookNo")String bookNo);
	//그럼 일단 책번호를 받는 api가 생겼음 
	
	
	
}
