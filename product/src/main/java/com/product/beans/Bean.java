package com.product.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bean {
	private Integer productId;
	private Integer noOfStocks;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(Integer noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	public Bean(Integer productId, Integer noOfStocks) {
		super();
		this.productId = productId;
		this.noOfStocks = noOfStocks;
	}
	public Bean() {
		super();
	}
	@Override
	public String toString() {
		return "Bean [productId=" + productId + ", noOfStocks=" + noOfStocks + "]";
	}
	
}
