package com.springHibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int studentId = 1;

			System.out.println("Getting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Dleleting student with id : " + studentId);
//			session.delete(myStudent);

			session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
