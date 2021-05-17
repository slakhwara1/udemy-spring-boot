package com.springHibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernateDemo.entity.Course;
import com.hibernateDemo.entity.Instructor;
import com.hibernateDemo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int instructorId = 1;

			session.beginTransaction();

			Query<Instructor> query = session.createQuery(
					"SELECT i FROM Instructor i " + "JOIN FETCH i.courses " + "WHERE i.id =: theInstructorId",
					Instructor.class);

			query.setParameter("theInstructorId", instructorId);

			Instructor tempInstructor = query.getSingleResult();

			System.out.println("Got the instructor : " + tempInstructor);

			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("The session is now CLOSED !!! \n\n");
			
			System.out.println("Got the Instructor's courses : \n" + tempInstructor.getCourses() + "\n");
			

			System.out.println("Donw!!! ");

		} finally {

			session.close();
			factory.close();
		}

	}

}
