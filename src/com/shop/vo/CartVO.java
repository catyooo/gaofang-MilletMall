package com.shop.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartVO implements Serializable {

	private static final long serialVersionUID = 1L;

    /** 订单列表*/
	private List<ShoppingCartVO> shoppingCartVOs;
	
	/** 订单总数量 */
	private Integer totalNumber;
	
	/** 订单总价格 */
	private BigDecimal totalPrice;

	public CartVO() {
		List<ShoppingCartVO> list = new ArrayList<ShoppingCartVO>();
		this.setShoppingCartVOs(list);
	}

	public List<ShoppingCartVO> getShoppingCartVOs() {
		return shoppingCartVOs;
	}

	public void setShoppingCartVOs(List<ShoppingCartVO> shoppingCartVOs) {
		this.shoppingCartVOs = shoppingCartVOs;
	}
	
	public Integer getTotalNumber() {
		Integer totalNumberTemp = 0;
		for (ShoppingCartVO shoppingCartVO : shoppingCartVOs) {
			totalNumberTemp += shoppingCartVO.getBuyNumber();
		}
		return totalNumberTemp;
	}

	public BigDecimal getTotalPrice() {
		System.out.println("#####");
		BigDecimal totalPriceTemp = BigDecimal.valueOf(0.0);
		for (ShoppingCartVO shoppingCartVO : shoppingCartVOs) {
			totalPriceTemp = totalPriceTemp.add(shoppingCartVO.getProductAmount());
		}
		System.out.println("price" + totalPriceTemp.toString());
		return totalPriceTemp;
	}


	@Override
	public String toString() {
		return "CartVO{" +
				"shoppingCartVOs=" + shoppingCartVOs.size() +
				", totalNumber=" + totalNumber +
				", totalPrice=" + totalPrice +
				'}';
	}
}