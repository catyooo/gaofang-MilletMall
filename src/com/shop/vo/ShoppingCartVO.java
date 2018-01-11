package com.shop.vo;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ShoppingCartVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 购物车ID
	 */
	private Long cartId;

	/**
	 * 商品规格编号
	 */
	private Long productSpecNumber;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 购买数量
	 */
	private Integer buyNumber;


	/**
	 * 商品ID
	 */
	private Long productNumber;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 展示图片
	 */
	private String picImg;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 销售量
	 */
	private Integer salesVolume;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 商品总金额
	 */
	private BigDecimal productAmount;
	/**
	 * 规格：规格ID，以“,”相隔
	 */
	private String spec;
	/**
	 * 规格名称
	 */
	private List<String> specificationName;


	public BigDecimal getProductAmount() {
		BigDecimal productAmountTemp = this.getPrice().multiply(new BigDecimal(this.getBuyNumber()));
		return productAmountTemp;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductSpecNumber() {
		return productSpecNumber;
	}

	public void setProductSpecNumber(Long productSpecNumber) {
		this.productSpecNumber = productSpecNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicImg() {
		return picImg;
	}

	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public List<String> getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(List<String> specificationName) {
		this.specificationName = specificationName;
	}

	@Override
	public String toString() {
		return "ShoppingCartVO{" +
				"cartId=" + cartId +
				", productSpecNumber=" + productSpecNumber +
				", userId=" + userId +
				", buyNumber=" + buyNumber +
				", productNumber=" + productNumber +
				", name='" + name + '\'' +
				", picImg='" + picImg + '\'' +
				", stock=" + stock +
				", salesVolume=" + salesVolume +
				", price=" + price +
				", productAmount=" + productAmount +
				", spec='" + spec + '\'' +
				", specificationName=" + specificationName +
				'}';
	}
}