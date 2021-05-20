package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.*(..)))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccount() {

		System.out.println("\n\n ===>>>>>>> Ecxecuting @Before advice on addAccount");

	}

	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n\\n ===>>>>>>> Performing API Analytics");
	}

}
