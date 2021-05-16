package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int instructorId = 1;
			
			session.beginTransaction();

			Instructor theInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("Got the instructor : " + theInstructor);
			
			if(theInstructor != null) {
				System.out.println("Deleting instructor: "+ theInstructor);
				session.delete(theInstructor);				
			}

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
