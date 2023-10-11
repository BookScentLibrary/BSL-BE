//package com.samsam.bsl.book.search;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import com.samsam.bsl.book.rent.domain.Book;
//import com.samsam.bsl.book.rent.dto.BookDTO;
//import com.samsam.bsl.book.rent.repository.BookRepository;
//import com.samsam.bsl.book.search.repository.SearchRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//
//
//@Repository
//public class SearchDAO {
	
//	@Autowired
//SearchRepository searchRepository;

	
//	    @Autowired
//	    private JdbcTemplate jdbcTemplate;
//
//	    public Page<Book> selectBooksBySearch(String searchValue) {
//	        String sql = "SELECT * FROM books "
//	                + "WHERE bookname LIKE ? "
//	                + "ORDER BY bookNo DESC";
//	        
//	        //이 부분도 나중에 마이바티스 연결 때문에 바꿔야 된다고 한다. 
//	        
//	        Page<Book> bookDTOs;
//	        List<Book> bookList;
//	        try {
//	             bookList = jdbcTemplate.query
//	            		 (sql, new RowMapper<Book>() {
//	                @Override
//	                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                    Book bookDTO = new Book();
//
//	                    bookDTO.setBookNo(rs.getInt("b_bookNo"));
//	                    bookDTO.setBookname(rs.getString("b_bookname"));
//	                    bookDTO.setAuthor(rs.getString("b_author"));
//	                    bookDTO.setPublisher(rs.getString("b_publisher"));
//	                    bookDTO.setPublicationYear(rs.getString("b_publish_year"));
//	                    bookDTO.setCallNum(rs.getString("b_call_number"));
//	                    bookDTO.setFormat(rs.getString("b_format"));
//	                    bookDTO.setClassName(rs.getString("b_class_name"));
//	                    bookDTO.setBookStatus(rs.getInt("b_status"));
//	                    bookDTO.setRentCnt(rs.getInt("b_rent_cnt"));
//	                    bookDTO.setIsbn(rs.getString("b_isbn"));
//	                    bookDTO.setDescription(rs.getString("b_description"));
//
//	                    return bookDTO;
//	                }
//	            }, "%" + searchValue + "%");
//	             
//	             
//	             
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
	
		
	
			
//	
//	        int pageNumber = 0; // 0부터 시작하는 페이지 번호 
//	    	int pageSize = 10; // size는 한 페이지에 반환한 데이터의 개수 
//	    	Sort sort = Sort.by("bookname").ascending(); // 정렬 기준 (예: 제목을 오름차순으로 정렬)
//	    	
//	    	Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
//	    	
//	    	Page<Book> resultPage = SearchRepository.findAll(pageable);
//	    	
//	    	
//	        PageRequest pageRequest = PageRequest.of(pageNumber,  pageSize);
//	        
//	        if (pageNumber >= 0 && pageNumber < bookList.size() && pageSize > pageNumber) {
//	            bookDTOs = new PageImpl<>(bookList.subList(pageNumber, pageSize), pageRequest, bookList.size());
//	        } else {
//	            bookDTOs = new PageImpl<>(Collections.emptyList(), pageRequest, 0);
//	        }
//	        
//	        
//	    	int start = (int) pageRequest.getOffset();
//	    	int end = Math.min((start + pageRequest.getPageSize()),bookList.size());
//	        
//	        bookDTOs = new PageImpl<>(bookList.subList(start,end), pageRequest, bookList.size()); // start, end, PageRequest객체
//	        return bookDTOs.getSize() > 0 ? bookDTOs : null;
//	    }
//	   
//	}

