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

	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.get*(..)))")
	private void getter() {}
	
	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.set*(..)))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())") 
	private void forDaoPackageNoGetterAndSetter() {}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccount() {

		System.out.println("\n\n ===>>>>>>> Ecxecuting @Before advice on ");

	}

	@Before("forDaoPackageNoGetterAndSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n\n ===>>>>>>> Performing API Analytics");
	}

}
