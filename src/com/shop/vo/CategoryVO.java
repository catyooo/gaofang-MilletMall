package com.shop.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.shop.po.OsProduct;


public class CategoryVO implements Serializable{

	private Long categoryId;

    private String name;

    List<OsProduct> products;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OsProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OsProduct> products) {
		this.products = products;
	}
	
}
