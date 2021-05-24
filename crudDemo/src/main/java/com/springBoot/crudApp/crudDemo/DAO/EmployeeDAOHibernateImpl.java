package com.springBoot.crudApp.crudDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.crudApp.crudDemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {

		Session session = entityManager.unwrap(Session.class);

		Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, id);

		return employee;
	}

	@Override
	public void save(Employee employee) {

		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		query.setParameter("employeeId", id);

		query.executeUpdate();

	}

}
