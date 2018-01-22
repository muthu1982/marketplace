package com.marketplace.vo;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable{


	private String code;
	private String name;	
	private String description;	
	private Integer maxBudget;	
	private Date lastDate;	
	private Integer lowestBid;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Integer getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(Integer maxBudget) {
		this.maxBudget = maxBudget;
	}

	
	
	public Integer getLowestBid() {
		return lowestBid;
	}

	public void setLowestBid(Integer lowestBid) {
		this.lowestBid = lowestBid;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", description=" + description + ", budget=" + maxBudget + ", lastDate="
				+ lastDate + "]";
	}
	
	
}
