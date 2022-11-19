package com.teja.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.dao.CustomerDao;
import com.teja.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	public Object getCustomersService() {
		return customerDao.getCustomerList();
	}
	
	@Transactional
	public Object deleteCustomerService(String customerId) {
		return customerDao.deleteCustomer(customerId);
	}
	
	@Transactional
	public Object saveCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}
	
	@Transactional
	public Object getCustomerByIdService(String id) {
		return customerDao.getCustomerById(id);
	}
	
	@Transactional
	public Object updateCustomerService(Customer customer) {
		return customerDao.updateCustomer(customer);
	}
}
