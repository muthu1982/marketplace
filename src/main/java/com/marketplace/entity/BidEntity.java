package com.marketplace.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BID")
public class BidEntity implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="USER_ID",nullable=false)
	private int userId;
	
	@Column(name="PROJECT_ID",nullable=false)
	private int projectId;
	
	@Column(name="BID_AMOUNT",nullable=false)
	private int bidAmount;
	
	@Column(name="BID_DATE",nullable=false)
	private Date bidDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	@Override
	public String toString() {
		return "BidEntity [id=" + id + ", userId=" + userId + ", projectId=" + projectId + ", bidAmount=" + bidAmount
				+ ", bidDate=" + bidDate + "]";
	}
	
	
	
}
