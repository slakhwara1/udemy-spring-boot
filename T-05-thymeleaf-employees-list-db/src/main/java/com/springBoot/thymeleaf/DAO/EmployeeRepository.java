package com.springBoot.thymeleaf.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
	
}
