package com.springApp.springDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springApp.springDemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		Session currentSession = this.sessionFactory.getCurrentSession();

		Query<Customer> query = currentSession.createQuery("FROM Customer", Customer.class);

		List<Customer> customerList = query.getResultList();

		return customerList;
	}

}
