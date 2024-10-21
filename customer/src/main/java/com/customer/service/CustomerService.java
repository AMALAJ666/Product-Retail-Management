package com.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.Exception.CustomerNotFoundException;
import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	Logger logger=LoggerFactory.getLogger(CustomerService.class);
	
@Autowired
CustomerRepository cRepo;
@Autowired
RestTemplate rTemplate;

public Customer addCustomer(Customer customer)
{
	logger.info("======================================");
	logger.info("addCustomer() called from service layer");
	logger.info("addCustomer() ended from service layer");
	logger.info("======================================");
	return cRepo.save(customer);
}
public Customer getCustomerById(Integer id)throws CustomerNotFoundException
{
	logger.info("======================================");
	logger.info("getCustomerById() called from service layer");
	Customer customer=cRepo.findById(id).orElse(null);
	if(customer==null)
	{
		logger.error("customer id not found for id={}",id);
		logger.info("======================================");
		throw new CustomerNotFoundException("Customer not found ");
	}
	logger.info("======================================");
	logger.info("getCustomerById() ended from service layer");
	logger.info("======================================");
	return customer;
}

}
