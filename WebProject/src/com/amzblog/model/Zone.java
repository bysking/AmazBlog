package com.amzblog.model;

import java.util.Date;

/**
 * Zone entity. @author MyEclipse Persistence Tools
 */

public class Zone implements java.io.Serializable {

	// Fields

	private Integer zoneId;
	private User user;
	private String zoneName;
	private Date zoneCreateDate;
	private String zoneStyle;

	// Constructors

	/** default constructor */
	public Zone() {
	}

	/** full constructor */
	public Zone(User user, String zoneName, Date zoneCreateDate, String zoneStyle) {
		this.user = user;
		this.zoneName = zoneName;
		this.zoneCreateDate = zoneCreateDate;
		this.zoneStyle = zoneStyle;
	}

	// Property accessors

	public Integer getZoneId() {
		return this.zoneId;
	}
	
	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneStyle() {
		return this.zoneStyle;
	}

	public void setZoneStyle(String zoneStyle) {
		this.zoneStyle = zoneStyle;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public Date getZoneCreateDate() {
		return this.zoneCreateDate;
	}

	public void setZoneCreateDate(Date zoneCreateDate) {
		this.zoneCreateDate = zoneCreateDate;
	}

}