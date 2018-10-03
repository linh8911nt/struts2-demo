/**
 * 
 */
package com.fa.linhnt49.struts2.action;

import java.io.IOException;
import java.sql.SQLException;

import com.fa.linhnt49.struts2.constants.PageConstants;
import com.fa.linhnt49.struts2.entity.Content;
import com.fa.linhnt49.struts2.logging.DbLogger;
import com.fa.linhnt49.struts2.service.ContentService;
import com.fa.linhnt49.struts2.service.impl.ContentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class GetContentJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentService contentService = new ContentServiceImpl();
	private Content content;
	private int id;
	
	public String getContentById() {
		try {
			content = contentService.findById(id);
		} catch (ClassNotFoundException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (IOException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		}
		return PageConstants.SUCCESS;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public Content getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(Content content) {
		this.content = content;
	}
	
}
