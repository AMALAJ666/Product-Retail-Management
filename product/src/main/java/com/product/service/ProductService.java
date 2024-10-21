package com.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Exception.ProductNotFoundException;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	ProductRepository pRepo;
	Logger logger=LoggerFactory.getLogger(ProductService.class);
	
	public Product addProduct(Product product)//add product
	{
		logger.info("======================================");
		logger.info("addProduct() called from service layer");
		logger.info("addProduct() ended from service layer");
		logger.info("======================================");
		return pRepo.save(product);
	}
	public Product getProductById(Integer id) throws ProductNotFoundException//get product by id
	{
		logger.info("======================================");
		logger.info("getProductById() called from service layer");
		Product product=pRepo.findById(id).orElse(null);
		if(product==null)
		{
			logger.error("product id not found for id={}",id);
			logger.info("======================================");
			throw new ProductNotFoundException("Product with id :"+id+" not found");
		}
		logger.info("======================================");
		logger.info("getProductById() ended from service layer");
		return product;
	}
	public List<Product> getProductByName(String name) throws ProductNotFoundException//to get result by name
	{
		logger.info("======================================");
		logger.info("getProductByName() called from service layer");
		List<Product> list= pRepo.findProductByProductName(name);
		if(list.isEmpty())
		{
			logger.error("product with name ={}",name);
			logger.info("======================================");
			throw new ProductNotFoundException("Product with name :"+name+" not found");
		}
		logger.info("======================================");
		logger.info("getProductByName() ended from service layer");
		
		return list;
	}
	public List<Product> getProductByCategory(String category) throws ProductNotFoundException//to get result by category
	{
		logger.info("======================================");
		logger.info("getProductByCategory() called from service layer");
		List<Product> list= pRepo.findProductByCategory(category);
		if(list.isEmpty())
		{
			logger.error("product with category ={} not found",category);
			logger.info("======================================");
			throw new ProductNotFoundException("Product with category :"+category+" not found");
		}
		logger.info("======================================");
		logger.info("getProductByCategory() ended from service layer");
		return list;
	}
	public Product addToStockBasedOnId(Integer productid, Integer noOfStock) throws ProductNotFoundException{
		logger.info("======================================");
		logger.info("addToStockBasedOnId() called from service layer");
	        Product product = pRepo.findById(productid).orElse(null);
	        if (product == null) {
	        	logger.error("product with id ={} not found cant update the current stocks",productid);
				logger.info("======================================");
	            throw new ProductNotFoundException("Product id not found, can't update the stocks");
	        }
	        
	        product.setStock(product.getStock() + noOfStock);
	        pRepo.save(product);
	        logger.info("======================================");
			logger.info("addToStockBasedOnId() ended from service layer");
	        return product;
	    } 
	
	    public Product removeFromStockBasedOnId(Integer productid, Integer noOfStock)throws ProductNotFoundException {
	    	logger.info("======================================");
			logger.info("removeFromStockBasedOnId() called from service layer");
		        Product product = pRepo.findById(productid).orElse(null);
		        if (product == null) {
		        	logger.error("product with id ={} not found cant update the current stocks",productid);
					logger.info("======================================");
		            throw new ProductNotFoundException("Product id not found, can't update the stocks");
		        }
		        
		        product.setStock(product.getStock() - noOfStock);
		        pRepo.save(product);
		        logger.info("======================================");
				logger.info("removeFromStockBasedOnId() ended from service layer");
		        return product;
		    } 
	    }


