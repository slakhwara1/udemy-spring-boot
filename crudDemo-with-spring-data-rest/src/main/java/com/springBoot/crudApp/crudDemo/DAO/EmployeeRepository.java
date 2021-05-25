package com.springBoot.crudApp.crudDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.crudApp.crudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
