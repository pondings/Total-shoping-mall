package com.tsm.project.dto;

import java.util.Date;

public class orderDto {

	private String custCode;
	private String empCode;
	private String orderCode;
	private Date startDate;
	private Date endDate;

	public orderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderDto(String custCode, String empCode, String orderCode, Date startDate, Date endDate) {
		super();
		this.custCode = custCode;
		this.empCode = empCode;
		this.orderCode = orderCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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
