package com.springBoot.crudApp.crudDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.crudApp.crudDemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {

		Query query = this.entityManager.createQuery("FROM Employee");

		List<Employee> employees = query.getResultList();
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Employee employee = this.entityManager.find(Employee.class, id);

		return employee;
	}

	@Override
	public void save(Employee employee) {

		Employee dbEmployee = this.entityManager.merge(employee);

		employee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int id) {

		Query query = this.entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");

		query.setParameter("employeeId", id);

		query.executeUpdate();

	}

}
