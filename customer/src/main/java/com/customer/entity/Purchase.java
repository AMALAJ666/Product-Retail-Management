package com.customer.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @NotNull(message = "Product ID is mandatory")
    private Integer productId;
    @NotNull(message = "Product name is mandatory")
    private String productName;
    private LocalDateTime purchaseDate;
    @NotNull(message = "Status is mandatory")
    private String status;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;
    @Min(value = 0, message = "Total value must be 0 or greater")
    private Integer totalValue;
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}
	public Purchase(Long purchaseId, Customer customer, @NotNull(message = "Product ID is mandatory") Integer productId,
			@NotNull(message = "Product name is mandatory") String productName, LocalDateTime purchaseDate,
			@NotNull(message = "Status is mandatory") String status,
			@Min(value = 1, message = "Quantity must be greater than 0") Integer quantity,
			@Min(value = 0, message = "Total value must be 0 or greater") Integer totalValue) {
		super();
		this.purchaseId = purchaseId;
		this.customer = customer;
		this.productId = productId;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.status = status;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}
	public Purchase() {
		super();
	}
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", customer=" + customer + ", productId=" + productId
				+ ", productName=" + productName + ", purchaseDate=" + purchaseDate + ", status=" + status
				+ ", quantity=" + quantity + ", totalValue=" + totalValue + "]";
	}
    
   
	
}
