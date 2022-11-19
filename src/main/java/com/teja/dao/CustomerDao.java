package com.teja.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teja.entity.Customer;
import com.teja.exceptions.CustomerNotFoundException;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory factory;
	
	public Object getCustomerList() {
		Session session = factory.getCurrentSession();
		Query query = session.createNativeQuery("select * from customer", Customer.class);
		List<Customer> customersList = query.getResultList();
		return customersList;
	}
	
	public Object addCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.save(customer);
		return customer;
	}
	
	public Object deleteCustomer(String id) {
		Session session = factory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		session.delete(customer);
		return customer;
	}
	
	public Object getCustomerById(String id) {
		Session session = factory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return customer;
	}
	
	public Object updateCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);
		return customer;
	}
}
