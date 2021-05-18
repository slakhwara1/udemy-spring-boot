package com.springApp.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springApp.springDemo.dao.CustomerDAO;
import com.springApp.springDemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customerList = this.customerDAO.getCustomers();

		theModel.addAttribute("customers", customerList);

		return "list-customers";

	}

}
