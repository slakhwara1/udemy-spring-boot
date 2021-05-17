package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;
import com.hibernateDemo.entity.Review;
import com.hibernateDemo.entity.Student;

public class AddCoursesForJohnAndMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int johnId = 1;
			int maryId = 2;

			session.beginTransaction();

			Student existingStudent1 = session.get(Student.class, johnId);
			Student existingStudent2 = session.get(Student.class, maryId);

			System.out.println("Loaded Student : " + existingStudent1);
			System.out.println("Loaded Student : " + existingStudent2);

			Course newCourse1 = new Course("Node JS");
			Course newCourse2 = new Course("Angular 9");

			newCourse1.addStudent(existingStudent1);
			newCourse1.addStudent(existingStudent2);
			newCourse2.addStudent(existingStudent1);
			newCourse2.addStudent(existingStudent2);

			session.save(newCourse1);
			session.save(newCourse2);

			System.out.println("Saved the course : " + newCourse1);
			System.out.println("Saved the course : " + newCourse2);
			System.out.println("\n\n\n");

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
