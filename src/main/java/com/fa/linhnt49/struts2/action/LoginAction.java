/**
 * 
 */
package com.fa.linhnt49.struts2.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fa.linhnt49.struts2.constants.PageConstants;
import com.fa.linhnt49.struts2.dto.MemberDataAccess;
import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.service.MemberService;
import com.fa.linhnt49.struts2.service.impl.MemberServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author nguyenthanhlinh
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<MemberDataAccess>, SessionAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberDataAccess memberDataAccess = new MemberDataAccess();
	private Map<String, Object> memberSessions;
	private MemberService memberService = new MemberServiceImpl();
	private HttpServletRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		Member member = new Member();
		member.setEmail(memberDataAccess.getEmail());
		member.setPassword(memberDataAccess.getPassword());
		
		Member dbMember = memberService.findByEmailAndPassword(member);
		if (dbMember != null) {
			memberSessions.put("member", dbMember);
			return PageConstants.SUCCESS;
		}
		String mesg = "Wrong Username or Password!!";
		request.setAttribute("mesg", mesg);
		return PageConstants.ERROR;
	}

	/**
	 * @return
	 */
	public String redirectRegister() {
		return PageConstants.SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public MemberDataAccess getModel() {
		return memberDataAccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.memberSessions = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
