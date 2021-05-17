package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int instructorDetailId = 2;

			session.beginTransaction();

			InstructorDetail existingInstructorDetail = session.get(InstructorDetail.class, instructorDetailId);

			System.out.println("Got the instructor detail: " + existingInstructorDetail);

			if (existingInstructorDetail != null) {
				System.out.println("Getting instructor now : ");
				System.out.println(existingInstructorDetail.getInstructor());
			}

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
