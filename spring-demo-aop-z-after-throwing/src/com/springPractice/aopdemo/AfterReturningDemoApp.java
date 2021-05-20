package com.springPractice.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springPractice.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accountList = theAccountDAO.findAccounts(false);

		System.out.println("\n\n Main Program: AfterReturningDemoApp : ");
		System.out.println(accountList + "\n");

		context.close();

	}
}
