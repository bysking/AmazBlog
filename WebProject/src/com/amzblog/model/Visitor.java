package com.amzblog.model;

import java.sql.Timestamp;

/**
 * Visitor entity. @author MyEclipse Persistence Tools
 */

public class Visitor implements java.io.Serializable {

	// Fields

	private Integer visitorId;
	private String remoteAddr;
	private Timestamp visitTime;
	private String localAddr;
	private String remoteHost;

	// Constructors

	/** default constructor */
	public Visitor() {
	}

	/** full constructor */
	public Visitor(String remoteAddr, Timestamp visitTime, String localAddr,
			String remoteHost) {
		this.remoteAddr = remoteAddr;
		this.visitTime = visitTime;
		this.localAddr = localAddr;
		this.remoteHost = remoteHost;
	}

	// Property accessors

	public Integer getVisitorId() {
		return this.visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	public String getRemoteAddr() {
		return this.remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public Timestamp getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public String getLocalAddr() {
		return this.localAddr;
	}

	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	public String getRemoteHost() {
		return this.remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

}