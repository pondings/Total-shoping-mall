package com.tsm.project.dto;

public class orderDto {

	private String prodCode;
	private String prodName;
	private Long prodPrice;
	private Integer subQuantity;
	private Integer subTotal;
	
	public orderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderDto(String prodCode, String prodName, Long prodPrice, Integer subQuantity, Integer subTotal) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.subQuantity = subQuantity;
		this.subTotal = subTotal;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Long getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Integer getSubQuantity() {
		return subQuantity;
	}

	public void setSubQuantity(Integer subQuantity) {
		this.subQuantity = subQuantity;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	

}
