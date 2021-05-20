package com.springPractice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringAppAopExpressions {

	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.*(..)))")
	public void forDaoPackage() {}

	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.get*(..)))")
	public void getter() {}
	
	@Pointcut("execution(* com.springPractice.aopdemo.dao.*.set*(..)))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())") 
	public void forDaoPackageNoGetterAndSetter() {}
	
	
}
