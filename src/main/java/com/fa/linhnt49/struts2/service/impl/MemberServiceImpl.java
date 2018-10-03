/**
 * 
 */
package com.fa.linhnt49.struts2.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fa.linhnt49.struts2.dao.MemberDAO;
import com.fa.linhnt49.struts2.dao.impl.MemberDAOImpl;
import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.service.MemberService;

/**
 * @author nguyenthanhlinh
 *
 */
public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	
	/**
	 * 
	 */
	public MemberServiceImpl() {
		this.memberDAO = new MemberDAOImpl();
	}

	@Override
	public int save(Member member) throws ClassNotFoundException, SQLException, IOException {
		return this.memberDAO.save(member);
	}

	@Override
	public List<Member> findAll() throws SQLException, ClassNotFoundException, IOException {
		return this.memberDAO.findAll();
	}

	@Override
	public Member findByEmailAndPassword(Member member) throws SQLException, ClassNotFoundException, IOException {
		return this.memberDAO.findByEmailAndPassword(member);
	}

}
