package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.springPractice.aopdemo.aspect.SpringAppAopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccount() {

		System.out.println("\n\n ===>>>>>>> Ecxecuting @Before advice on ");

	}

}
