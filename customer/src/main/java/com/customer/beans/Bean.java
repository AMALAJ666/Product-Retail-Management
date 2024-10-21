package com.customer.beans;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bean {
	   @NotNull(message = "Customer ID is mandatory")
	private Integer customerId;
	   @NotNull(message = "Product ID is mandatory")
	private Integer productId;
	   @Min(value = 1, message = "Quantity must be greater than 0")
	private Integer quantity;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Bean(@NotNull(message = "Customer ID is mandatory") Integer customerId,
			@NotNull(message = "Product ID is mandatory") Integer productId,
			@Min(value = 1, message = "Quantity must be greater than 0") Integer quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public Bean() {
		super();
	}
	@Override
	public String toString() {
		return "Bean [customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
