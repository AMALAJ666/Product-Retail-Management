package com.customer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Exception.CustomerNotFoundException;
import com.customer.Exception.PurchaseNotfoundexception;
import com.customer.beans.Bean;
import com.customer.beans.CustomerPurchaseHistoryDTO;
import com.customer.entity.Purchase;
import com.customer.service.PurchaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "http://localhost:8081")
public class PurchaseController {
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	  @Autowired
	   private PurchaseService pService;
	  @PostMapping
	    public ResponseEntity<Purchase> makePurchase(@Valid @RequestBody Bean bean ) throws PurchaseNotfoundexception, CustomerNotFoundException {
		  logger.info("======================================");
			logger.info("makePurchase() called from purchase controller");
	        Purchase purchase = pService.makePurchase(bean);
	        logger.info("purchase={}",purchase);
			logger.info("makePurchase() ended from purchase controller");
			logger.info("======================================");
	        return new ResponseEntity<>(purchase, HttpStatus.OK);
	    }
	  
	  @GetMapping("/{customerId}")//get history of product purchased based on cid
	    public ResponseEntity< CustomerPurchaseHistoryDTO > getPurchaseHistory(@PathVariable Integer customerId) throws CustomerNotFoundException {
		  logger.info("======================================");
			logger.info("getPurchaseHistory() called from purchase controller");
			 CustomerPurchaseHistoryDTO purchases = pService.getPurchaseHistory(customerId);
	        logger.info("purchases={}",purchases);
			logger.info("getPurchaseHistory() ended from purchase controller");
			logger.info("======================================");
	        return new ResponseEntity<>(purchases, HttpStatus.OK);
	    }
}


