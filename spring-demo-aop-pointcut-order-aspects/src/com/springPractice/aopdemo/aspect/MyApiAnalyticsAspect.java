package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.springPractice.aopdemo.aspect.SpringAppAopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n\n ===>>>>>>> Performing API Analytics");
	}

}
