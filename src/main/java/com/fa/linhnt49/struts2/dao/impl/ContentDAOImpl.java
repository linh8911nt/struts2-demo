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
import com.fa.linhnt49.struts2.dao.ContentDAO;
import com.fa.linhnt49.struts2.db.DbConnect;
import com.fa.linhnt49.struts2.entity.Content;
import com.fa.linhnt49.struts2.entity.Member;

/**
 * @author nguyenthanhlinh
 *
 */
public class ContentDAOImpl implements ContentDAO {

	@Override
	public List<Content> findAllByAuthorId(Member member) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Content> contents = new ArrayList<>();
		Content content = new Content();

		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.FIND_ALL_BY_AUTHOR_ID);
			pstm.setInt(1, member.getId());

			rs = pstm.executeQuery();
			while (rs.next()) {
				content.setId(rs.getInt("Id"));
				content.setTitle(rs.getString("Title"));
				content.setBrief(rs.getString("Brief"));
				content.setContent(rs.getString("Content"));
				content.setCreateDate(rs.getDate("CreateDate"));
				content.setUpdateTime(rs.getDate("UpdateTime"));
				content.setAuthorId(member);

				contents.add(content);
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
		return contents;
	}

	@Override
	public Content findById(int id) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Content content = new Content();
		Member member = new Member();
		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.FIND_BY_ID);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			while (rs.next()) {
				content.setId(rs.getInt("Id"));
				content.setTitle(rs.getString("Title"));
				content.setBrief(rs.getString("Brief"));
				content.setContent(rs.getString("Content"));
				content.setCreateDate(rs.getDate("CreateDate"));
				content.setUpdateTime(rs.getDate("UpdateTime"));
				
				member.setId(rs.getInt("AuthorId"));
				content.setAuthorId(member);
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
		return content;
	}

	@Override
	public int updateContent(Content content) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;
		int affectedRow = 0;
		try {
			conn = DbConnect.getConnection();
			pstm = conn.prepareStatement(DbQueries.UPDATE_CONTENT);
			pstm.setString(1, content.getTitle());
			pstm.setString(2, content.getBrief());
			pstm.setString(3, content.getContent());
			pstm.setDate(4, content.getUpdateTime());
			pstm.setInt(5, content.getId());
			
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

}
