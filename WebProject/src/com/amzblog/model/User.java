package com.amzblog.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String userPassword;
	private String userNickname;
	private String userSex;
	private Short userAge;
	private Date userBirthdate;
	private String userSelfie;
	private String userEmailAddr;
	private String userBlogAddr;
	private String userWechat;
	private String userQq;
	private String userPhone;
	private Set feelings = new HashSet(0);
	private Set friendshipsForFriendId = new HashSet(0);	//通过getFriendshipsForFriendId()得到的是User本人
	private Set friendshipsForUserId = new HashSet(0);		//通过getFriendshipsForUserId()，得到的是user的朋友们
	private Set comments = new HashSet(0);
	private Set messages = new HashSet(0);
	private Set zones = new HashSet(0);
	private Set msgboxes = new HashSet(0);
	private Set blogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String userPassword, String userNickname,
			String userBlogAddr) {
		this.username = username;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userBlogAddr = userBlogAddr;
	}

	/** full constructor */
	public User(String username, String userPassword, String userNickname,
			String userSex, Short userAge, Date userBirthdate,
			String userSelfie, String userEmailAddr, String userBlogAddr,
			String userWechat, String userQq, String userPhone, Set feelings,
			Set friendshipsForFriendId, Set friendshipsForUserId, Set comments,
			Set messages, Set zones, Set msgboxes, Set blogs) {
		this.username = username;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userBirthdate = userBirthdate;
		this.userSelfie = userSelfie;
		this.userEmailAddr = userEmailAddr;
		this.userBlogAddr = userBlogAddr;
		this.userWechat = userWechat;
		this.userQq = userQq;
		this.userPhone = userPhone;
		this.feelings = feelings;
		this.friendshipsForFriendId = friendshipsForFriendId;
		this.friendshipsForUserId = friendshipsForUserId;
		this.comments = comments;
		this.messages = messages;
		this.zones = zones;
		this.msgboxes = msgboxes;
		this.blogs = blogs;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Short getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Short i) {
		this.userAge = i;
	}

	public Date getUserBirthdate() {
		return this.userBirthdate;
	}

	public void setUserBirthdate(Date userBirthdate) {
		this.userBirthdate = userBirthdate;
	}

	public String getUserSelfie() {
		return this.userSelfie;
	}

	public void setUserSelfie(String userSelfie) {
		this.userSelfie = userSelfie;
	}

	public String getUserEmailAddr() {
		return this.userEmailAddr;
	}

	public void setUserEmailAddr(String userEmailAddr) {
		this.userEmailAddr = userEmailAddr;
	}

	public String getUserBlogAddr() {
		return this.userBlogAddr;
	}

	public void setUserBlogAddr(String userBlogAddr) {
		this.userBlogAddr = userBlogAddr;
	}

	public String getUserWechat() {
		return this.userWechat;
	}

	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Set getFeelings() {
		return this.feelings;
	}

	public void setFeelings(Set feelings) {
		this.feelings = feelings;
	}

	public Set getFriendshipsForFriendId() {
		return this.friendshipsForFriendId;
	}

	public void setFriendshipsForFriendId(Set friendshipsForFriendId) {
		this.friendshipsForFriendId = friendshipsForFriendId;
	}

	public Set getFriendshipsForUserId() {
		return this.friendshipsForUserId;
	}

	public void setFriendshipsForUserId(Set friendshipsForUserId) {
		this.friendshipsForUserId = friendshipsForUserId;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getZones() {
		return this.zones;
	}

	public void setZones(Set zones) {
		this.zones = zones;
	}

	public Set getMsgboxes() {
		return this.msgboxes;
	}

	public void setMsgboxes(Set msgboxes) {
		this.msgboxes = msgboxes;
	}

	public Set getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

}