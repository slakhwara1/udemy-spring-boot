package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;
import com.hibernateDemo.entity.Review;
import com.hibernateDemo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course newCourse = new Course("python-flask-contents");
			session.save(newCourse);
			System.out.println("Saved the course : " + newCourse);
			System.out.println("\n\n\n");

			Student student1 = new Student("Sam", "Smith", "sam@gmail.com");
			Student student2 = new Student("Dave", "Norton", "dave@gmail.com");

			newCourse.addStudent(student1);
			newCourse.addStudent(student2);

			System.out.println("Saving Students : ");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students : " + newCourse.getStudents());

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
