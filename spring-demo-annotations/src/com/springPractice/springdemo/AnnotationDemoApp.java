package com.springPractice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);

//		Coach thePracticeCoach = context.getBean("practiceActivity_4_Coach", Coach.class);
 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

//		System.out.println(thePracticeCoach.getDailyWorkout());

		context.close();

	}

}
