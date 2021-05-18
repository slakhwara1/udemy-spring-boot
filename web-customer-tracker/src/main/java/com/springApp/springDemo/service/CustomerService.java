package com.springApp.springDemo.service;

import java.util.List;

import com.springApp.springDemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
