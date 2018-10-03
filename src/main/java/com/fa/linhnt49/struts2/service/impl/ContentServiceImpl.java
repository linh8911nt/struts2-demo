/**
 * 
 */
package com.fa.linhnt49.struts2.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fa.linhnt49.struts2.dao.ContentDAO;
import com.fa.linhnt49.struts2.dao.impl.ContentDAOImpl;
import com.fa.linhnt49.struts2.entity.Content;
import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.service.ContentService;

/**
 * @author nguyenthanhlinh
 *
 */
public class ContentServiceImpl implements ContentService {
	
	private ContentDAO contentDAO;
	
	public ContentServiceImpl() {
		this.contentDAO = new ContentDAOImpl();
	}

	/* (non-Javadoc)
	 * @see com.fa.linhnt49.struts2.service.ContentService#findAllByAuthorId(com.fa.linhnt49.struts2.entity.Member)
	 */
	@Override
	public List<Content> findAllByAuthorId(Member member) throws ClassNotFoundException, SQLException, IOException {
		return contentDAO.findAllByAuthorId(member);
	}

	@Override
	public Content findById(int id) throws SQLException, ClassNotFoundException, IOException {
		return contentDAO.findById(id);
	}

	@Override
	public int updateContent(Content content) throws ClassNotFoundException, SQLException, IOException {
		return contentDAO.updateContent(content);
	}

}
