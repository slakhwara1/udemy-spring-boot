package com.springRest.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springdemo.entity.Customer;
import com.springRest.springdemo.rest.CustomerNotFoundException;
import com.springRest.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return this.customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCUstomer(@PathVariable int customerId) {

		Customer customer = this.customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return customer;
	}

	@PostMapping("/api/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);

		this.customerService.saveCustomer(customer);

		return customer;
	}

}
