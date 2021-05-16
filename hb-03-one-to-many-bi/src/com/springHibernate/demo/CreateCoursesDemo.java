package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int instructorId = 1;

			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, instructorId);

			Course course1 = new Course("Java");
			Course course2 = new Course("C#");
			Course course3 = new Course("Python");

			System.out.println("Adding courses to instructor");

			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);

			session.save(course1);
			session.save(course2);
			session.save(course3);


			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
