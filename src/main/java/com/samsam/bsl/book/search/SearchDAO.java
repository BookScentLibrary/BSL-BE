package com.samsam.bsl.book.search;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.samsam.bsl.book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class SearchDAO {
	
	
//	 @Autowired
//	    private JdbcTemplate jdbcTemplate;
//
//	    public List<BookDTO> selectBooksBySearch(String bookName) {
//	        String sql = "SELECT * FROM books "
//	                + "WHERE bookname LIKE ? "
//	                + "ORDER BY bookNo DESC";
//
//	        List<BookDTO> bookDTOs = null;
//
//	        try {
//	            bookDTOs = jdbcTemplate.query(
//	                new PreparedStatementCreator() {
//	                    @Override
//	                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//	                        PreparedStatement ps = con.prepareStatement(sql);
//	                        ps.setString(1, "%" + bookName + "%");
//	                        return ps;
//	                    }
//	                }, new RowMapper<BookDTO>() {
//	                    @Override
//	                    public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//	                        // 동일한 필드에 여러 번 값을 설정하는 오류를 수정했습니다.
//	                        BookDTO bookDTO = new BookDTO();
//	                        bookDTO.setBookNo(rs.getInt("b_bookNo"));
//	                        bookDTO.setBookImageURL(rs.getString("b_bookImageURL"));
//	                        bookDTO.setBookname(rs.getString("b_bookname"));
//	                        bookDTO.setAuthor(rs.getString("b_author"));
//	                        bookDTO.setPublisher(rs.getString("b_publisher"));
//	                        bookDTO.setPublicationYear(rs.getString("b_publish_year"));
//	                        bookDTO.setCallNum(rs.getString("b_call_number"));
//	                        bookDTO.setBookformat(rs.getString("b_format"));
//	                        bookDTO.setClassname(rs.getString("b_class_name")); // 필드 이름 수정
//	                        bookDTO.setBookStatus(rs.getInt("b_status"));
//	                        bookDTO.setRentCnt(rs.getInt("b_rent_cnt"));
//	                        bookDTO.setIsbn(rs.getString("b_isbn"));
//	                        bookDTO.setDescription(rs.getString("b_description"));
//	                        return bookDTO;
//	                    }
//	                });
//	        } catch (Exception e) {
//	            e.printStackTrace(); // 예외 처리를 개선해야 합니다.
//	        }
//	        return bookDTOs != null && !bookDTOs.isEmpty() ? bookDTOs : null;
//	    }
	
	
	
	
	
	
	
	
	

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public List<BookDTO> selectBooksBySearch(BookDTO bookDTO) {
	        String sql = "SELECT * FROM books "
	                + "WHERE bookname LIKE ? "
	                + "ORDER BY bookNo DESC";
	        
	        //이 부분도 나중에 마이바티스 연결 때문에 바꿔야 된다고 한다. 
	        
	        List<BookDTO>bookDTOs = null;

	        try {
	             bookDTOs = jdbcTemplate.query
	            		 (sql, new RowMapper<BookDTO>() {
	                @Override
	                public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    BookDTO bookDTO = new BookDTO();

	                    bookDTO.setBookNo(rs.getInt("b_bookNo"));
	                    bookDTO.setBookImageURL(rs.getString("b_bookImageURL"));
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
	            }, "%" + bookDTO.getBookname() + "%");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bookDTOs.size() > 0 ? bookDTOs : null;
	    }
	   
	}

