/**
 * 
 */
package com.fa.linhnt49.struts2.dto;

/**
 * @author nguyenthanhlinh
 *
 */
public class MemberDataAccess {

	private String userName;
	private String password;
	private String email;
	private String rePassword;

	/**
	 * 
	 */
	public MemberDataAccess() {

	}

	/**
	 * @param userName
	 * @param password
	 * @param email
	 */
	public MemberDataAccess(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the rePassword
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * @param rePassword the rePassword to set
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
