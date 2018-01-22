package com.marketplace.vo;

import java.sql.Date;

public class Bid {

	private String emailId;
	private String projectCode;
	private int bidAmount;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	
	
}
