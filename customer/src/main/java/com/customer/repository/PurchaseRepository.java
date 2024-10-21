package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	List<Purchase> findByCustomerCustomerId(Integer customerId);

}
