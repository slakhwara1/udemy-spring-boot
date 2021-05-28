package com.springBoot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.thymeleaf.entity.Employee;
import com.springBoot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employees = this.employeeService.findAll();
		
		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee newEmployee = new Employee();
		
		model.addAttribute("employee" , newEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
		
		Employee existingEmployee = this.employeeService.findById(employeeId);
		
		model.addAttribute("employee" , existingEmployee);
		
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		this.employeeService.save(employee);
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeId) {
		
		this.employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list";
	}
	
}
