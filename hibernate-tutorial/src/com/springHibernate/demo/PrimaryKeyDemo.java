package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating 3 new student objects ...");

			Student newStudent1 = new Student("Paul", "Wall", "paul@gmail.com");
			Student newStudent2 = new Student("Mary", "Public", "mary@gmail.com");
			Student newStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the students ... ");
			session.save(newStudent1);
			session.save(newStudent2);
			session.save(newStudent3);

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
