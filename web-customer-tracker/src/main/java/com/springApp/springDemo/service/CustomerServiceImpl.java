package com.springApp.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springApp.springDemo.dao.CustomerDAO;
import com.springApp.springDemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> customerList = this.customerDAO.getCustomers();
				
		return customerList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		this.customerDAO.saveCustomer(theCustomer);
	}

}
