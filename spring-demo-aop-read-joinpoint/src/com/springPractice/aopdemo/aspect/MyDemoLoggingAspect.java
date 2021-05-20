package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springPractice.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.springPractice.aopdemo.aspect.SpringAppAopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {

		System.out.println("\n\n ===>>>>>>> Ecxecuting @Before advice on ");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: " + methodSignature);

		Object[] args = joinPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("Account name : " + account.getName());
				System.out.println("Account level : " + account.getLevel());
			}
		}

	}

}
