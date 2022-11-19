package com.teja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teja.entity.Customer;
import com.teja.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/listCustomers")
	public Object getCustomersList() {
		return customerService.getCustomersService();
	}
	
	@GetMapping("/deleteCustomer/{customerId}")
	public Object deleteCustomer(@PathVariable String customerId) {
		return customerService.deleteCustomerService(customerId);
	}
	
	@PostMapping("/addOrUpdateCustomer")
	public Object addOrUpdateCustomer(@RequestBody Customer customer) {
		if(customer.getId() != null) {
			return customerService.updateCustomerService(customer);
		}
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public Object getCustomerById(@PathVariable String customerId) {
		return customerService.getCustomerByIdService(customerId);
	}

}
