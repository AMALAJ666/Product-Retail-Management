package com.customer.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer productId;
    private String productName;
    private String category;
    private Integer unitPrice;
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

    // Method to calculate the stock value
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

	public Product(Integer productId, String productName, String category, Integer unitPrice, Integer stock,
			Integer stockValue, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stock = stock;
		this.stockValue = stockValue;
		this.description = description;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", stock=" + stock + ", stockValue=" + stockValue + ", description="
				+ description + "]";
	}

   
}
