package com.springBoot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.thymeleaf.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees;

	@PostConstruct
	private void loadData() {

		Employee employee1 = new Employee("Leslie", "Andrews", "leslie@gmail.com");
		Employee employee2 = new Employee("Emma", "Baumgarten", "emma@gmail.com");
		Employee employee3 = new Employee("Avani", "Gupta", "avani@gmail.com");
		Employee employee4 = new Employee("Joao", "felix", "joao@gmail.com");
		Employee employee5 = new Employee("Felix", "Baumbgartner", "felix@gmail.com");

		this.employees = new ArrayList<Employee>();
		this.employees.add(employee1);
		this.employees.add(employee2);
		this.employees.add(employee3);
		this.employees.add(employee4);
		this.employees.add(employee5);

	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		model.addAttribute("employees", this.employees);

		return "list-employees";
	}
}
