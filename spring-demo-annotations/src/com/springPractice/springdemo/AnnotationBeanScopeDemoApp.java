package com.springPractice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n Pointing to the same object: " + result);
		
		System.out.println("\n Memory location of theCoach: " + theCoach);
		System.out.println("\n Memory location of alphaCoach: " + alphaCoach);
		
		context.close();
		
	}

}
