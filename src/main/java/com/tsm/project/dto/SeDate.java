package com.tsm.project.dto;

import java.util.Date;

public class SeDate {
	private Date startDate;
	private Date endDate;
	public SeDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeDate(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
