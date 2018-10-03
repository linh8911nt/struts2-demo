package com.fa.linhnt49.struts2.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

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
public class UpdateContentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentService contentService = new ContentServiceImpl();
	private int id;
	private String title;
	private String brief;
	private String content;
	private String message;

	public String updateContent() {
		LocalDate updateTimeLocal = LocalDate.now();
		Date updateTime = Date.valueOf(updateTimeLocal);
		
		Content inputContent = new Content(id, title, brief, content, updateTime);
		int affectedRow = 0;
		try {
			affectedRow = contentService.updateContent(inputContent);
		} catch (ClassNotFoundException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (IOException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		}
		if (affectedRow > 0) {
			message = "Update Success!!!";
			return PageConstants.SUCCESS;
		}
		return PageConstants.ERROR;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the brief
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * @param brief the brief to set
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
