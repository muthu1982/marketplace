package com.marketplace.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class ProjectEntity implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Column(name="CODE",nullable=false,unique=true)
	private String code;
	
	@Column(name="DESCRIPTION",nullable=false)
	private String description;
	
	@Column(name="BUDGET",nullable=false)
	private Integer budget;
	
	@Column(name="LAST_DATE",nullable=false)
	private Date lastDate;
	
	@Column(name="ASSIGNED_USER")
    private String assignedUser;
	
	@Column(name="STATUS")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
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

	public String getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", budget=" + budget + ", lastDate=" + lastDate + ", assignedUser=" + assignedUser + ", status="
				+ status + "]";
	}

	
	
}
