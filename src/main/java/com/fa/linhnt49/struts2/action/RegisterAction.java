/**
 * 
 */
package com.fa.linhnt49.struts2.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.fa.linhnt49.struts2.constants.PageConstants;
import com.fa.linhnt49.struts2.dto.MemberDataAccess;
import com.fa.linhnt49.struts2.entity.Member;
import com.fa.linhnt49.struts2.logging.DbLogger;
import com.fa.linhnt49.struts2.logging.LoggingUtils;
import com.fa.linhnt49.struts2.service.MemberService;
import com.fa.linhnt49.struts2.service.impl.MemberServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author nguyenthanhlinh
 *
 */
public class RegisterAction extends ActionSupport implements ModelDriven<MemberDataAccess> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	private MemberDataAccess memberDataAccess = new MemberDataAccess();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute(){
		memberService = new MemberServiceImpl();
		
		LocalDate createDate = LocalDate.now();
		Date dbCreateDate = Date.valueOf(createDate);
		
		Member dbMember = new Member(memberDataAccess.getUserName(), memberDataAccess.getPassword(), memberDataAccess.getEmail(), dbCreateDate);
		
		boolean isRePasswordEqualPassword = memberDataAccess.getPassword().equals(memberDataAccess.getRePassword());
		int affectedRow = 0;
		
		try {
			if (isRePasswordEqualPassword) {
				affectedRow = memberService.save(dbMember);
				LoggingUtils.LOGGER.info("Register new member");
			}
		} catch (ClassNotFoundException e) {
			DbLogger.LOGGER.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			DbLogger.LOGGER.error("SQLException", e);
		} catch (IOException e) {
			DbLogger.LOGGER.error("IOException", e);
		}
		
		if (affectedRow > 0) {
			return PageConstants.SUCCESS;
		} else {
			return PageConstants.ERROR;
		}
	}
	
	public String redirectLogin() {
		return PageConstants.SUCCESS;
	}

	@Override
	public MemberDataAccess getModel() {
		return memberDataAccess;
	}
}
