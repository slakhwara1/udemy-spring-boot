package com.springBoot.crudApp.crudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.crudApp.crudDemo.DAO.EmployeeRepository;
import com.springBoot.crudApp.crudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = this.employeeRepository.findAll();
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

}
