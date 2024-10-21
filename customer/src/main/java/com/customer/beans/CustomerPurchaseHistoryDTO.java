package com.customer.beans;

import java.util.List;

import com.customer.entity.Customer;
import com.customer.entity.Purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseHistoryDTO {
    private Customer customer;
    private List<Purchase> purchases;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	public CustomerPurchaseHistoryDTO(Customer customer, List<Purchase> purchases) {
		super();
		this.customer = customer;
		this.purchases = purchases;
	}
	public CustomerPurchaseHistoryDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerPurchaseHistoryDTO [customer=" + customer + ", purchases=" + purchases + "]";
	}
    
}
