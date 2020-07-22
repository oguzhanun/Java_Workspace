package com.oguzhanun.aopdemo.aspects;

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

import com.oguzhanun.aopdemo.Account;


@Aspect
@Component
@Order(4)
public class MyAspectDemoApp2 {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.oguzhanun.aopdemo.service.*.getFortune(..))")
	public Object methodOfAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		long start = System.currentTimeMillis();
		
		logger.info("Right now you are in the joinpoint of : " + proceedingJoinPoint.getSignature().toShortString());
		
		Object result = proceedingJoinPoint.proceed();
		
		long finish = System.currentTimeMillis();
		
		logger.info("Elapsed Time : " + (finish-start));
		
		//@Around faaliyetininin kendisini çağırması ile bu faaliyeti döngüsel bir hale dönüştürebiliriz...
		//methodOfAroundAdvice(proceedingJoinPoint);
		
		return result;
	}
	
	@After("execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void methodOfAfterAdvice(JoinPoint joinPoint) {
		
		logger.info("After Advice in the method :" + joinPoint.getSignature().toShortString());
	}
	
	@AfterThrowing(pointcut="execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exception")
	public void methodOfAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
		
		logger.info("AfterThrowing Advice in the method :" + joinPoint.getSignature().toShortString() 
				+ "has the error: " + exception );
	}
	
	@AfterReturning(pointcut="execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts())", returning="result")
	public void afterReturningPointcutMethod(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("AfterReturning Method :" + method);
		
		logger.info("the result is : " + result);
	}
	
	@Before("com.oguzhanun.aopdemo.aspects.MyAspectDemoApp.comboPointcut()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		logger.info("\nxxx====>>>>BEFOREADDACCOUNTADVICE()<<<====XXX: " + methodSignature);
		
		Object[] arguments = joinPoint.getArgs();
		
		for(Object obj : arguments) {
			
			logger.info("Method Argument: " + obj);
			
			if(obj instanceof Account){
				Account account = (Account) obj;
				logger.info("Account Name : " + account.getName());
				logger.info("Account Level : " + account.getLevel());
			}
		}
	}
}
