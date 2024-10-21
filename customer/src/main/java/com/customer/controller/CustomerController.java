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
import com.customer.beans.ApiResponse;
import com.customer.entity.Customer;
import com.customer.service.CustomerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:8081")
public class CustomerController {
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService cService;
	@PostMapping("/register")//add customer
	public ResponseEntity<ApiResponse> addCustomer( @Valid @RequestBody Customer customer)
	{
		logger.info("======================================");
		logger.info("addCustomer() called from customer controller");
		customer=cService.addCustomer(customer);
		logger.info("customer={}",customer);
		logger.info("addCustomer() ended from customer controller");
		logger.info("======================================");
		ApiResponse response = new ApiResponse("Customer added.", 202);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	@GetMapping("/search/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable("id") Integer id) throws CustomerNotFoundException {
		logger.info("======================================");
		logger.info("getCustomerByID() called from customer controller");
            Customer customer = cService.getCustomerById(id);
            logger.info("customer={}",customer);
    		logger.info("getCustomerByID() ended from customer controller");
    		logger.info("======================================");

            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
	   
	
}
