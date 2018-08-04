package com.amzblog.model;

import java.sql.Timestamp;

/**
 * Feeling entity. @author MyEclipse Persistence Tools
 */

public class Feeling implements java.io.Serializable {

	// Fields

	private Integer feelId;
	private User user;
	private String feelContent;
	private Timestamp feelCreateTime;

	// Constructors

	/** default constructor */
	public Feeling() {
	}

	/** full constructor */
	public Feeling(User user, String feelContent, Timestamp feelCreateTime) {
		this.user = user;
		this.feelContent = feelContent;
		this.feelCreateTime = feelCreateTime;
	}

	// Property accessors

	public Integer getFeelId() {
		return this.feelId;
	}

	public void setFeelId(Integer feelId) {
		this.feelId = feelId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFeelContent() {
		return this.feelContent;
	}

	public void setFeelContent(String feelContent) {
		this.feelContent = feelContent;
	}

	public Timestamp getFeelCreateTime() {
		return this.feelCreateTime;
	}

	public void setFeelCreateTime(Timestamp feelCreateTime) {
		this.feelCreateTime = feelCreateTime;
	}

}