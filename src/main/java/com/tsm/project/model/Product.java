package com.tsm.project.model;
// Generated Feb 5, 2016 10:56:28 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", schema = "main")
public class Product implements java.io.Serializable {

	private int id;
	private ProductType productType;
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private Integer prodQuantity;
	private Long prodPrice;
	private String prodBrand;
	private String prodColor;
	private String prodModel;
	private Integer prodStatus;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private String prodImg;

	public Product() {
	}

	public Product(int id) {
		this.id = id;
	}

	public Product(int id, ProductType productType, String prodCode, String prodName, String prodDesc,
			Integer prodQuantity, Long prodPrice, String prodBrand, String prodColor, String prodModel,
			Integer prodStatus, String createBy, Date createDate, String updateBy, Date updateDate, String prodImg) {
		this.id = id;
		this.productType = productType;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodQuantity = prodQuantity;
		this.prodPrice = prodPrice;
		this.prodBrand = prodBrand;
		this.prodColor = prodColor;
		this.prodModel = prodModel;
		this.prodStatus = prodStatus;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.prodImg = prodImg;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Column(name = "prod_code", length = 45)
	public String getProdCode() {
		return this.prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	@Column(name = "prod_name", length = 45)
	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "prod_desc", length = 100)
	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	@Column(name = "prod_quantity")
	public Integer getProdQuantity() {
		return this.prodQuantity;
	}

	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	@Column(name = "prod_price")
	public Long getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Column(name = "prod_brand", length = 45)
	public String getProdBrand() {
		return this.prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	@Column(name = "prod_color", length = 45)
	public String getProdColor() {
		return this.prodColor;
	}

	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}

	@Column(name = "prod_model", length = 45)
	public String getProdModel() {
		return this.prodModel;
	}

	public void setProdModel(String prodModel) {
		this.prodModel = prodModel;
	}

	@Column(name = "prod_status")
	public Integer getProdStatus() {
		return this.prodStatus;
	}

	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}

	@Column(name = "create_by", length = 45)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", length = 13)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_by", length = 45)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_date", length = 13)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "prod_img", length = 250)
	public String getProdImg() {
		return this.prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

}
