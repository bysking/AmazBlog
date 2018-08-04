package com.amzblog.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer msgId;
	private User user;
	private String msgContent;
	private Timestamp msgCreateTime;
	private Set msgboxes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(User user, String msgContent, Timestamp msgCreateTime) {
		this.user = user;
		this.msgContent = msgContent;
		this.msgCreateTime = msgCreateTime;
	}

	/** full constructor */
	public Message(User user, String msgContent, Timestamp msgCreateTime,
			Set msgboxes) {
		this.user = user;
		this.msgContent = msgContent;
		this.msgCreateTime = msgCreateTime;
		this.msgboxes = msgboxes;
	}

	// Property accessors

	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Timestamp getMsgCreateTime() {
		return this.msgCreateTime;
	}

	public void setMsgCreateTime(Timestamp msgCreateTime) {
		this.msgCreateTime = msgCreateTime;
	}

	public Set getMsgboxes() {
		return this.msgboxes;
	}

	public void setMsgboxes(Set msgboxes) {
		this.msgboxes = msgboxes;
	}

}