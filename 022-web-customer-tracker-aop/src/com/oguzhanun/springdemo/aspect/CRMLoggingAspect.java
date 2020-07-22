package com.oguzhanun.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.oguzhanun.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}

	@Pointcut("execution(* com.oguzhanun.springdemo.services.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.oguzhanun.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("forDAOPackage() || forServicePackage() || forControllerPackage() ")
	public void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void loggingMethod(JoinPoint joinPoint) {
		
		logger.info("===========>>>>>>>>>>>>> @Before Advice in : " + joinPoint.getSignature().toShortString());
		
		Object[] arguments = joinPoint.getArgs();
		
		for(Object arg : arguments) {
			logger.info("=========>>>>>>>> arguments : " + arg);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void returningMethod(JoinPoint joinPoint, Object result) {
		
		logger.info("===========>>>>>>>>>>>>> @AfterReturning Advice out of : " + joinPoint.getSignature().toShortString());
		
		logger.info("===========>>>>>>>>>>>>> Result is : " + result);
	}
	
	
	
	
	
	
	
}
