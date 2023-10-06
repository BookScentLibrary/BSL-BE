package com.samsam.bsl.book.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samsam.bsl.book.rent.domain.Book;
import com.samsam.bsl.book.rent.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class SearchDAO {
	
	


	
	
	

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public List<Book> selectBooksBySearch(String searchValue) {
	        String sql = "SELECT * FROM books "
	                + "WHERE bookname LIKE ? "
	                + "ORDER BY bookNo DESC";
	        
	        //이 부분도 나중에 마이바티스 연결 때문에 바꿔야 된다고 한다. 
	        
	        List<Book>bookDTOs =new ArrayList<>();

	        try {
	             bookDTOs = jdbcTemplate.query
	            		 (sql, new RowMapper<Book>() {
	                @Override
	                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    Book bookDTO = new Book();

	                    bookDTO.setBookNo(rs.getInt("b_bookNo"));
	                    bookDTO.setBookname(rs.getString("b_bookname"));
	                    bookDTO.setAuthor(rs.getString("b_author"));
	                    bookDTO.setPublisher(rs.getString("b_publisher"));
	                    bookDTO.setPublicationYear(rs.getString("b_publish_year"));
	                    bookDTO.setCallNum(rs.getString("b_call_number"));
	                    bookDTO.setFormat(rs.getString("b_format"));
	                    bookDTO.setClassName(rs.getString("b_class_name"));
	                    bookDTO.setBookStatus(rs.getInt("b_status"));
	                    bookDTO.setRentCnt(rs.getInt("b_rent_cnt"));
	                    bookDTO.setIsbn(rs.getString("b_isbn"));
	                    bookDTO.setDescription(rs.getString("b_description"));

	                    return bookDTO;
	                }
	            }, "%" + searchValue + "%");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bookDTOs.size() > 0 ? bookDTOs : null;
	    }
	   
	}

