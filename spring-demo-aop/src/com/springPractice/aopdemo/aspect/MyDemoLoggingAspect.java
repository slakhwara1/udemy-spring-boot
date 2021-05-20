package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Before("execution(* com.springPractice.aopdemo.dao.*.*(..)))")
	public void beforeAddAccount() {

		System.out.println("\n\n ===>>>>>>> Ecxecuting @Before advice on addAccount");

	}

}
