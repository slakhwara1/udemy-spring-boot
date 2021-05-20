package com.springPractice.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springPractice.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\n Main Program : AroundDemoApp");

		System.out.println("Calling Fortune");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("My Fortune is : " + data);

		System.out.println("Finished");

		context.close();

	}
}
