/**
 * 
 */
package com.fa.linhnt49.struts2.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.linhnt49.struts2.constants.PageConstants;
import com.fa.linhnt49.struts2.entity.Content;
import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.logging.DbLogger;
import com.fa.linhnt49.struts2.service.ContentService;
import com.fa.linhnt49.struts2.service.impl.ContentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class ViewContentsAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentService contentService = new ContentServiceImpl();
	private List<Content> contents;
	private Map<String, Object> memberSessions;

	public String showViewContentsPage() {
		
		Member member = (Member) memberSessions.get("member");
		
		try {
			contents = contentService.findAllByAuthorId(member);
		} catch (ClassNotFoundException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			DbLogger.LOGGER.error("SQLException", e);
		} catch (IOException e) {
			DbLogger.LOGGER.error("IOException", e);
		}
		return PageConstants.SUCCESS;
	}

	/**
	 * @return the contents
	 */
	public List<Content> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.memberSessions = session;
	}

}
