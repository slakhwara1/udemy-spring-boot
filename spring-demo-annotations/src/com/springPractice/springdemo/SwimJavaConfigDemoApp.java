package com.springPractice.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

//		Coach thePracticeCoach = context.getBean("practiceActivity_4_Coach", Coach.class);
 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Email : " + theCoach.getEmail());
		System.out.println("Team : " + theCoach.getTeam());		

//		System.out.println(thePracticeCoach.getDailyWorkout());

		context.close();

	}

}
