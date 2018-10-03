/**
 * 
 */
package com.fa.linhnt49.struts2.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.logging.DbLogger;
import com.fa.linhnt49.struts2.service.MemberService;
import com.fa.linhnt49.struts2.service.impl.MemberServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class RegisterJsonAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Member> members;
	private MemberService memberService = new MemberServiceImpl();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute(){
		try {
			members = memberService.findAll();
		} catch (ClassNotFoundException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			DbLogger.LOGGER.error("SQLException", e);
		} catch (IOException e) {
			DbLogger.LOGGER.error("IOException", e);
		}
		
		return "REGISTER";
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
