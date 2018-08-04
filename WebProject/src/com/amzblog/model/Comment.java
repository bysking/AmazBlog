package com.amzblog.model;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commId;
	private User user;
	private Blog blog;
	private String commContent;
	private Timestamp commCreateTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(User user, Blog blog, String commContent,
			Timestamp commCreateTime) {
		this.user = user;
		this.blog = blog;
		this.commContent = commContent;
		this.commCreateTime = commCreateTime;
	}

	// Property accessors

	public Integer getCommId() {
		return this.commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getCommContent() {
		return this.commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public Timestamp getCommCreateTime() {
		return this.commCreateTime;
	}

	public void setCommCreateTime(Timestamp commCreateTime) {
		this.commCreateTime = commCreateTime;
	}

}