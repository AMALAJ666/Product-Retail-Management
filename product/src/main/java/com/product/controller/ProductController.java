package com.product.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Exception.ProductNotFoundException;
import com.product.beans.ApiResponse;
import com.product.beans.Bean;
import com.product.entity.Product;
import com.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	Logger logger=LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService pService;
	
	@PostMapping
	public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody Product product) {
	    logger.info("======================================");
	    logger.info("addProduct() called from product controller");
	    pService.addProduct(product);
	    ApiResponse response = new ApiResponse("Product added.", 202);
	    logger.info("======================================");
	    logger.info("addProduct() ended from product controller");
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")//get details based on id
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id)throws ProductNotFoundException
	{
		logger.info("======================================");
		logger.info("getCustomerByID() called from product controller");
		Product product=pService.getProductById(id);
		 logger.info("product={}",product);
 		logger.info("getCustomerByID() ended from product controller");
 		logger.info("======================================");
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	@GetMapping("/productname/{name}")//based on product name
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name) throws ProductNotFoundException
	{
		logger.info("======================================");
		logger.info("getProductByName() called from product controller");
		List<Product> list=pService.getProductByName(name);
		logger.info("productlist={}",list);
	 	logger.info("getProductByName() ended from product controller");
	 	logger.info("======================================");
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@GetMapping("/category/{category}")//based on product name
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category) throws ProductNotFoundException
	{
		logger.info("======================================");
		logger.info("getProductByCategory() called from product controller");
		List<Product> list=pService.getProductByCategory(category);
		logger.info("productlist={}",list);
	 	logger.info("getProductByCategory() ended from product controller");
	 	logger.info("======================================");
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@PutMapping("/addinstock")//to add no. of stocks
	public ResponseEntity<Product> addNoOfStock(@RequestBody Bean bean) throws ProductNotFoundException {
		logger.info("======================================");
		logger.info("addNoOfStock() called from product controller");
		Product product = pService.addToStockBasedOnId(bean.getProductId(), bean.getNoOfStocks());
		logger.info("product={}",product);
	 	logger.info("addNoOfStock() ended from product controller");
	 	logger.info("======================================");
	    return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	@PutMapping("/removefromstock/{productId}/{noofstocks}")//to remove no. of stocks
	public ResponseEntity<Product> removeFromStockBasedOnId(@Valid @PathVariable("productId") Integer productId,@PathVariable("noofstocks") Integer noofstocks)throws ProductNotFoundException {
		logger.info("======================================");
		logger.info("removeFromStockBasedOnId() called from product controller");
		Product product = pService.removeFromStockBasedOnId(productId,noofstocks);
		logger.info("product={}",product);
	 	logger.info("removeFromStockBasedOnId() ended from product controller");
	 	logger.info("======================================");
	    return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}
