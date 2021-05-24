package com.springBoot.crudApp.crudDemo.DAO;

import java.util.List;

import com.springBoot.crudApp.crudDemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
