package com.samsam.bsl.newbook.save;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SaveListController implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SaveListController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
    	
//        try {
//            jdbcTemplate.execute("INSERT INTO newbook (bookname, author, publisher, regDate) " +
//                    "SELECT bookname, author, publisher, regDate " +
//                    "FROM books " +
//                    "ORDER BY regDate DESC " +
//                    "LIMIT 20");
//
//            System.out.println("데이터 복사 완.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            System.err.println("개허접");
//        }
        
    }
    
}