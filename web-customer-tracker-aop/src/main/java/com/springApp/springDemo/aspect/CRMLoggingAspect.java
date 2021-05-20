package com.springApp.springDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.springApp.springDemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.springApp.springDemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.springApp.springDemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {}
	
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n ======>>>  in @Before calling method :  " + method + "\n");
		
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("\n =========>>>>  Argument :  " + tempArg + "\n");
		}
		
	}
	
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n ======>>>  in @AfterReturning calling method :  " + method + "\n");
		
		myLogger.info("\n =======>>>>>>   " + result + "\n");
				
	}
	
}
