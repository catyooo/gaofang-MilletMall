package com.shop.vo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class ProductSpecificationVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 商品规格列表
	 */
	private Map<String, Object> productSpecifications;
	

	public Map<String, Object> getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(Map<String, Object> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
}
