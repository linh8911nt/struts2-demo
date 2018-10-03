/**
 * 
 */
package com.fa.linhnt49.struts2.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fa.linhnt49.struts2.entity.Content;
import com.fa.linhnt49.struts2.entity.Member;

/**
 * @author nguyenthanhlinh
 *
 */
public interface ContentDAO {
	
	List<Content> findAllByAuthorId(Member member) throws ClassNotFoundException, SQLException, IOException;
	
	Content findById(int id) throws SQLException, ClassNotFoundException, IOException;
	
	int updateContent(Content content) throws ClassNotFoundException, SQLException, IOException;

}
