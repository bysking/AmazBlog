package com.amzblog.model;

/**
 * Friendship entity. @author MyEclipse Persistence Tools
 */

public class Friendship implements java.io.Serializable {

	// Fields

	private Integer friendshipId;
	private User userByFriendId;
	private User userByUserId;

	// Constructors

	/** default constructor */
	public Friendship() {
	}

	/** full constructor */
	public Friendship(User userByFriendId, User userByUserId) {
		this.userByFriendId = userByFriendId;
		this.userByUserId = userByUserId;
	}

	// Property accessors

	public Integer getFriendshipId() {
		return this.friendshipId;
	}

	public void setFriendshipId(Integer friendshipId) {
		this.friendshipId = friendshipId;
	}

	public User getUserByFriendId() {
		return this.userByFriendId;
	}

	public void setUserByFriendId(User userByFriendId) {
		this.userByFriendId = userByFriendId;
	}

	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

}