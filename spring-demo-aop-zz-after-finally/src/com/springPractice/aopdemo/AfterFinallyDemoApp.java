package com.springPractice.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springPractice.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accountList = null;		
		
		try {
			boolean tripWire = true;
			 accountList = theAccountDAO.findAccounts(tripWire);			
			
		} catch (Exception e) {
			System.out.println("\n\n Main Program ... caught exception " + e);
		}
		
		System.out.println("\n\n Main Program: AfterThrowingDemoApp : ");
		System.out.println(accountList + "\n");

		context.close();

	}
}
