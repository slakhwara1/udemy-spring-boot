package com.springPractice.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.springPractice.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>> Executing @Around on method : " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			
			myLogger.warning(e.getMessage());

//			FOR SWALLOWING THE EXCEPTION
//			result = "Major Accident! But no worries, " + "your private AOP helicopter is on the way";
			
			throw e;
			
		}
		
		long end = System.currentTimeMillis();
		
		long duratin = end - begin;
		
		myLogger.info("\n =====>>>>> Duration : " + duratin/1000.0 + " seconds");
		
		return result;
	}
	
	
	@After("execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>>>> Executing @After (Finally) on method : " + method);
				
	}
	

	@AfterThrowing(
			pointcut = "execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>>>> Executing @AfterThrowing on method : " + method);
		
		myLogger.info("\n=====>>>>> The exception is : " + exc);		
		
	}
	

	@AfterReturning(
			pointcut = "execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\n=====>>>>> Executing @AfterReturning on method : " + method);
		
		myLogger.info("\n=====>>>>> Executing @AfterReturning on method : " + result);

		convertAccountNamesToUpperCase(result);

	}
	

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		result.forEach(account -> account.setName(account.getName().toUpperCase()));
		
	}


	@Before("com.springPractice.aopdemo.aspect.SpringAppAopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccount(JoinPoint joinPoint) {

		myLogger.info("\n\n ===>>>>>>> Ecxecuting @Before advice on ");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		myLogger.info("Method: " + methodSignature);

		Object[] args = joinPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("Account name : " + account.getName());
				myLogger.info("Account level : " + account.getLevel());
			}
		}

	}

}
