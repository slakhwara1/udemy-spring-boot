package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;
import com.hibernateDemo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course newCourse = new Course("Spring-boot");

			Review newReview1 = new Review("It is a great course");
			Review newReview2 = new Review("It is a bad thing");
			Review newReview3 = new Review("It is a fantastic course KUDOS");

			newCourse.addReview(newReview1);
			newCourse.addReview(newReview2);
			newCourse.addReview(newReview3);

			System.out.println("Saving the course : " + newCourse);
			session.save(newCourse);

			session.getTransaction().commit();

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
