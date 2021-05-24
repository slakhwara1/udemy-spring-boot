package com.springBoot.crudApp.crudDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.crudApp.crudDemo.DAO.EmployeeDAO;
import com.springBoot.crudApp.crudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> findAll() {

		List<Employee> employees = this.employeeDAO.findAll();
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int id) {

		Employee employee = this.employeeDAO.findById(id);
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		this.employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		this.employeeDAO.deleteById(id);
	}

}
