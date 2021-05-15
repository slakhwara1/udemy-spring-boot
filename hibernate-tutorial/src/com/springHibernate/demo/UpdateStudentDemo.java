package com.springHibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int studentId = 1;

			System.out.println("Getting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("UPDATING student...");

			myStudent.setFirstName("SCOOBY");

			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\n\n\nUPDATE email for all students");

			session.createQuery("UPDATE Student SET email='foo@ymail.com'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
