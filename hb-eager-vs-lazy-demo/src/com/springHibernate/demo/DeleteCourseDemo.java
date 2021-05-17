package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int courseId = 10;

			session.beginTransaction();

			Course existingCourse = session.get(Course.class, courseId);
			
			System.out.println("Got the course : "+ existingCourse);
			
			session.delete(existingCourse);
			

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
