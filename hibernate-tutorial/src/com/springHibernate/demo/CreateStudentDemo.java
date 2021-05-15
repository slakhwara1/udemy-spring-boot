package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating a new student object ...");
			Student newStudent = new Student("John", "Doe", "john.doe@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the sudent ... ");
			session.save(newStudent);

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
