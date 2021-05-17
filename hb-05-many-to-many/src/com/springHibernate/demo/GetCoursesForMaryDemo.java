package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;
import com.hibernateDemo.entity.Review;
import com.hibernateDemo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int maryId = 1;

			session.beginTransaction();

			Student existingStudent2 = session.get(Student.class, maryId);

			System.out.println("Loaded Student : " + existingStudent2);

			System.out.println("Courses" + existingStudent2.getCourses());

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
