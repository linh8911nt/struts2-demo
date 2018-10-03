/**
 * 
 */
package com.fa.linhnt49.struts2.constants;

/**
 * @author nguyenthanhlinh
 *
 */
public class DbQueries {
	
	public interface Member {
		public static final String SAVE_MEMBER = "INSERT INTO Member(UserName, Password, Email, CreateDate) VALUES (?, ?, ?, ?)";
	}
	
	public static final String FIND_ALL = "SELECT * FROM Member";
	public static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM Member WHERE Email = ? AND Password = ?";
	public static final String FIND_ALL_BY_AUTHOR_ID = "SELECT * FROM Content WHERE AuthorId = ?";
	public static final String FIND_BY_ID = "SELECT * FROM Content WHERE Id = ?";
	public static final String UPDATE_CONTENT = "UPDATE Content SET Title = ?, Brief = ?, Content = ?, UpdateTime = ? WHERE Id = ?";

}
