package com.springBoot.crudApp.crudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.crudApp.crudDemo.entity.Employee;
import com.springBoot.crudApp.crudDemo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("")
	public List<Employee> getEmployees() {

		List<Employee> employees = this.employeeService.findAll();

		return employees;
	}

	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee employee = this.employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id not found : " + employeeId);
		}

		return employee;
	}

	@PostMapping("")
	public Employee saveEmployee(@RequestBody Employee employee) {

		employee.setId(0);

		this.employeeService.save(employee);

		return employee;
	}

	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {

		this.employeeService.save(employee);

		return employee;
	}

	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee employee = this.employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id not found : " + employeeId);
		}

		this.employeeService.deleteById(employeeId);

		return "Deleted employee with id : " + employeeId;
	}

}
