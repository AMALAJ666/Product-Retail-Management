package com.product.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotNull(message = "Product name is mandatory")
    private String productName;

    @NotNull(message = "Category is mandatory")
    private String category;

    @NotNull(message = "Unit price is mandatory")
    @Positive(message = "Unit price must be positive")
    private Integer unitPrice;

    @NotNull(message = "Stock is mandatory")
    @Min(value = 1, message = "Stock cannot be negative")
    private Integer stock;

    private Integer stockValue;

    private String description;

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
        calculateStockValue();  // Recalculate stockValue whenever unitPrice changes
    }

    public void setStock(Integer stock) {
        this.stock = stock;
        calculateStockValue();  // Recalculate stockValue whenever stock changes
    }

    private void calculateStockValue() {
        if (unitPrice != null && stock != null) {
            this.stockValue = this.unitPrice * this.stock;
        } else {
            this.stockValue = null; // Set to null if any value is missing
        }
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getStockValue() {
		return stockValue;
	}

	public void setStockValue(Integer stockValue) {
		this.stockValue = stockValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public Integer getStock() {
		return stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", stock=" + stock + ", stockValue=" + stockValue + ", description="
				+ description + "]";
	}
    
}
