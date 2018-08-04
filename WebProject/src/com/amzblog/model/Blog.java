package com.amzblog.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private User user;
	private String blogTitle;
	private String blogContent;
	private String blogContentHtml;
	private Timestamp blogCreateTime;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** minimal constructor */
	public Blog(User user, String blogTitle, Timestamp blogCreateTime) {
		this.user = user;
		this.blogTitle = blogTitle;
		this.blogCreateTime = blogCreateTime;
	}

	/** full constructor */
	public Blog(User user, String blogTitle, String blogContent,
			String blogContentHtml, Timestamp blogCreateTime, Set comments) {
		this.user = user;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.blogContentHtml = blogContentHtml;
		this.blogCreateTime = blogCreateTime;
		this.comments = comments;
	}

	// Property accessors

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	public String getBlogContentHtml() {
		return this.blogContentHtml;
	}

	public void setBlogContentHtml(String blogContentHtml) {
		this.blogContentHtml = blogContentHtml;
	}

	public Timestamp getBlogCreateTime() {
		return this.blogCreateTime;
	}

	public void setBlogCreateTime(Timestamp blogCreateTime) {
		this.blogCreateTime = blogCreateTime;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}