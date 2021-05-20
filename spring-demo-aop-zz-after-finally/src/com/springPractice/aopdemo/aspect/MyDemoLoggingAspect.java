package com.springPractice.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>>> Executing @After (Finally) on method : " + method);
				
	}
	

	@AfterThrowing(
			pointcut = "execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>>> Executing @AfterThrowing on method : " + method);
		
		System.out.println("\n=====>>>>> The exception is : " + exc);		
		
	}
	

	@AfterReturning(
			pointcut = "execution(* com.springPractice.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>>> Executing @AfterReturning on method : " + method);
		
		System.out.println("\n=====>>>>> Executing @AfterReturning on method : " + result);

		convertAccountNamesToUpperCase(result);

	}
	

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		result.forEach(account -> account.setName(account.getName().toUpperCase()));
		
	}


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
