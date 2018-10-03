/**
 * 
 */
package com.fa.linhnt49.struts2.entity;

import java.sql.Date;

/**
 * @author nguyenthanhlinh
 *
 */
public class Content {

	private int id;
	private String title;
	private String brief;
	private String content;
	private Date createDate;
	private Date updateTime;
	private Member authorId;

	/**
	 * 
	 */
	public Content() {

	}
	
	

	/**
	 * @param id
	 * @param title
	 * @param brief
	 * @param content
	 * @param updateTime
	 */
	public Content(int id, String title, String brief, String content, Date updateTime) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.updateTime = updateTime;
	}



	/**
	 * @param id
	 * @param title
	 * @param brief
	 * @param content
	 * @param createDate
	 * @param updateTime
	 * @param authorId
	 */
	public Content(int id, String title, String brief, String content, Date createDate, Date updateTime,
			Member authorId) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.authorId = authorId;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the authorId
	 */
	public Member getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Member authorId) {
		this.authorId = authorId;
	}
}
