/**
 * 
 */
package com.fa.linhnt49.struts2.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fa.linhnt49.struts2.constants.DbQueries;
import com.fa.linhnt49.struts2.dao.MemberDAO;
import com.fa.linhnt49.struts2.db.DbConnect;
import com.fa.linhnt49.struts2.entity.Member;

/**
 * @author nguyenthanhlinh
 *
 */
public class MemberDAOImpl implements MemberDAO {

	@Override
	public int save(Member member) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		int affectedRow = 0;
		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.Member.SAVE_MEMBER);
			pstm.setString(1, member.getUserName());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getEmail());
			pstm.setDate(4, member.getCreateDate());

			affectedRow = pstm.executeUpdate();
		} finally {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return affectedRow;
	}

	@Override
	public List<Member> findAll() throws SQLException, ClassNotFoundException, IOException {
		List<Member> members = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.FIND_ALL);
			rs = pstm.executeQuery();
			
			Member member = null;
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("Id"));
				member.setUserName(rs.getString("UserName"));
				member.setEmail(rs.getString("Email"));
				member.setCreateDate(rs.getDate("CreateDate"));
				member.setFirstName(rs.getString("FirstName"));
				member.setLastName(rs.getString("LastName"));

				members.add(member);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return members;

	}

	@Override
	public Member findByEmailAndPassword(Member member) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Member dbMember = null;
		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.FIND_BY_EMAIL_AND_PASSWORD);
			pstm.setString(1, member.getEmail());
			pstm.setString(2, member.getPassword());
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				dbMember = new Member();
				dbMember.setId(rs.getInt("Id"));
				dbMember.setUserName(rs.getString("UserName"));
				dbMember.setPassword(rs.getString("Password"));
				dbMember.setEmail(rs.getString("Email"));
				dbMember.setCreateDate(rs.getDate("CreateDate"));
				dbMember.setFirstName(rs.getString("FirstName"));
				dbMember.setLastName(rs.getString("LastName"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return dbMember;
	}

}
