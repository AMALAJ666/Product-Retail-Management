package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findProductByProductName(String name);

	List<Product> findProductByCategory(String category);

}
