package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;
import com.hibernateDemo.entity.Review;
import com.hibernateDemo.entity.Student;

public class DeleteAngularCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int courseId = 12;

			session.beginTransaction();

			Course existingCourse = session.get(Course.class, courseId);
			
			System.out.println("Deleting course : " + existingCourse);
			
			session.delete(existingCourse);

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
