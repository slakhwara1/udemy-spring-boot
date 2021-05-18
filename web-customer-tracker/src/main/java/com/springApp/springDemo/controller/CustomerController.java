package com.springApp.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springApp.springDemo.entity.Customer;
import com.springApp.springDemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService ;
	

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customerList = this.customerService.getCustomers();

		theModel.addAttribute("customers", customerList);

		return "list-customers";

	}

}
