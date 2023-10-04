package com.samsam.bsl.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsam.bsl.user.dto.UserDTO;
@Component
public class UserDAO {

//	private final SqlSession sqlSession;
//	
//    @Autowired
//    public UserDAO(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }

	// 데이터 확인
//	public boolean isAdminMember(String a_m_id) {
//	System.out.println("[AdminMemberDAO] isAdminMember()");
//
//	String sql = "SELECT COUNT(*) FROM tbl_admin_member " + "WHERE a_m_id = ?";
//
//	int result = jdbcTemplate.queryForObject(sql, Integer.class, a_m_id);
//
//	if (result > 0) {
//		return true; // 중복
//	} else {
//		return false; // 중복되지 않음.
//	}
//}
	
}
