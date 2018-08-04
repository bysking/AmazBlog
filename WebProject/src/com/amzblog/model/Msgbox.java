package com.amzblog.model;

/**
 * Msgbox entity. @author MyEclipse Persistence Tools.
 */

public class Msgbox implements java.io.Serializable {

	// Fields

	private Integer msgBoxId;
	private User user;
	private Message message;

	// Constructors

	/** default constructor */
	public Msgbox() {
	}

	/** full constructor */
	public Msgbox(User user, Message message) {
		this.user = user;
		this.message = message;
	}

	// Property accessors

	public Integer getMsgBoxId() {
		return this.msgBoxId;
	}

	public void setMsgBoxId(Integer msgBoxId) {
		this.msgBoxId = msgBoxId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}