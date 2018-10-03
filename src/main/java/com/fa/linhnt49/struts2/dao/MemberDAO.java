package com.fa.linhnt49.struts2.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fa.linhnt49.struts2.entity.Member;

/**
 * @author nguyenthanhlinh
 *
 */
public interface MemberDAO {
	
	int save(Member member) throws ClassNotFoundException, SQLException, IOException;
	
	List<Member> findAll() throws SQLException, ClassNotFoundException, IOException;
	
	Member findByEmailAndPassword(Member member) throws SQLException, ClassNotFoundException, IOException;

}
