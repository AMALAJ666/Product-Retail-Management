package com.customer.service;

import java.time.LocalDateTime;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.Exception.CustomerNotFoundException;
import com.customer.Exception.PurchaseNotfoundexception;
import com.customer.beans.Bean;
import com.customer.beans.CustomerPurchaseHistoryDTO;
import com.customer.beans.Product;
import com.customer.controller.CustomerController;
import com.customer.entity.Customer;
import com.customer.entity.Purchase;
import com.customer.repository.PurchaseRepository;

import jakarta.transaction.Transactional;

@Service

public class PurchaseService {
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class); 
	
    @Autowired
    private PurchaseRepository pRepo;
    
    @Autowired
    private CustomerService cService;

   
    
    @Autowired
    private RestTemplate rTemplate;
    @Transactional
    public Purchase makePurchase(Bean bean)  throws PurchaseNotfoundexception, CustomerNotFoundException {
    	logger.info("======================================");
    	logger.info("makePurchase() called from service layer");
    	Customer customer = cService.getCustomerById(bean.getCustomerId());
    		
    	if(bean.getQuantity()<=0)
    	{
    		throw new PurchaseNotfoundexception("Purchase could not happen with id:"+bean.getProductId()+" quantity of product should be at least 1");
    	}
        Product product = rTemplate.getForObject("http://APIGATEWAYAPP/client2/product/" + bean.getProductId(), Product.class);
        if(product == null)
        {
        	logger.error("product id not found for id={}",bean.getProductId());
    		logger.info("======================================");
        	  throw new PurchaseNotfoundexception("product with id:"+bean.getProductId()+"  not found.");
        }
        	
        
        if (product.getStock() < bean.getQuantity()) {
        	logger.error("purchase could not happen for quantity={}",product.getStock());
    		logger.info("======================================");
            throw new PurchaseNotfoundexception("Insufficient stock or prodauct not found.");
        }

        // Updating stock on the product service
        product.setStock(product.getStock()-bean.getQuantity());
        rTemplate.put("http://APIGATEWAYAPP/client2/product/removefromstock/" + bean.getProductId() + "/" + bean.getQuantity(), Product.class);


        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setProductId(bean.getProductId());
        purchase.setProductName(product.getProductName());
        purchase.setPurchaseDate(LocalDateTime.now());
        purchase.setStatus("Completed");
        purchase.setQuantity(bean.getQuantity());
        purchase.setTotalValue(product.getUnitPrice() * bean.getQuantity());
        logger.info("======================================");
    	logger.info("makePurchase() ended from service layer");
      
        return pRepo.save(purchase);
    }
    


    public CustomerPurchaseHistoryDTO getPurchaseHistory(Integer customerId) throws CustomerNotFoundException {
        logger.info("======================================");
        logger.info("getPurchaseHistory() called from service layer");

        Customer customer = cService.getCustomerById(customerId);
        List<Purchase> purchases = pRepo.findByCustomerCustomerId(customerId);

        if (purchases.isEmpty()) {
            logger.error("No purchases found for customer id: {}", customerId);
            throw new CustomerNotFoundException("Customer not found or no purchases available.");
        }

        // Remove customer details from each purchase
        for (Purchase purchase : purchases) {
            purchase.setCustomer(null);
        }

        CustomerPurchaseHistoryDTO dto = new CustomerPurchaseHistoryDTO();
        dto.setCustomer(customer);
        dto.setPurchases(purchases);

        logger.info("getPurchaseHistory() ended from service layer");
        logger.info("======================================");

        return dto;
    }

}
