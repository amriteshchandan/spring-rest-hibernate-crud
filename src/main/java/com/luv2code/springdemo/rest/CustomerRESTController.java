package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRESTController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/customers", method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@RequestMapping(path = "/customers/{customerID}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable int customerID) {
		Customer customer = customerService.getCustomer(customerID);
		if (customer == null)
			throw new CustomerNotFoundException("Customer ID " + customerID + " not found.");
		return customer;
	}
	
	@RequestMapping(path = "/customers", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@RequestMapping(path = "/customers", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@RequestMapping(path = "/customers/{customerID}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable int customerID) {
		Customer customer = customerService.getCustomer(customerID);
		System.out.println("customer => " + customer);
		if (customer == null)
			throw new CustomerNotFoundException("Customer ID " + customerID + " not found.");
		customerService.deleteCustomer(customerID);
		return "Deleted customer with ID - " + customerID;
	}
	
}
