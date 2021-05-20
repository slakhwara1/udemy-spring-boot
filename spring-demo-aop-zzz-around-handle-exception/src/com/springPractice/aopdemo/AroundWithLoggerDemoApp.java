package com.springPractice.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springPractice.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("\n Main Program : AroundDemoApp");

		myLogger.info("Calling Fortune");

		String data = theTrafficFortuneService.getFortune();

		myLogger.info("My Fortune is : " + data);

		myLogger.info("Finished \n\n");

		context.close();

	}
}
