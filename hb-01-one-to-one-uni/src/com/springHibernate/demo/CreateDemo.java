package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube.com",
//					"Luv 2 code !!");
//
//			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com",
					"Playing !!");

			tempInstructor.setInstructorDetail(tempInstructorDetail);
			

			session.beginTransaction();

			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {
			factory.close();
		}

	}

}
