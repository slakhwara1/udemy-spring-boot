package com.springBoot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.thymeleaf.DAO.EmployeeRepository;
import com.springBoot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = this.employeeRepository.findAllByOrderByLastNameAsc();
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = this.employeeRepository.findById(id);

		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id : " + id);
		}

		return employee;
	}

	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchBy(String employeeName) {

		List<Employee> results = null;

		if (employeeName != null && (employeeName.trim().length() > 0)) {
			results = this.employeeRepository.findByFirstNameOrLastNameContainsAllIgnoreCase(employeeName,
					employeeName);
		} else {
			results = this.findAll();
		}

		return results;
	}

}
