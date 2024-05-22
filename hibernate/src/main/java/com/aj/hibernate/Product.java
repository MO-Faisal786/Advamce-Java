package com.aj.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	private Integer id;
	private String prodName;
	private String compName;
	private String type;
	private Integer prodPrice;
	private String prodDetails;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDetails() {
		return prodDetails;
	}
	public void setProdDetails(String prodDetails) {
		this.prodDetails = prodDetails;
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", prodName=" + prodName + ", compName=" + compName + ", type=" + type
				+ ", prodPrice=" + prodPrice + ", prodDetails=" + prodDetails + "]";
	}
	
	
}
