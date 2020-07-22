package com.oguzhanun.aopdemo.aspects;

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

import com.oguzhanun.aopdemo.Account;


@Aspect
@Component
@Order(4)
public class MyAspectDemoApp2 {

	@After("execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void methodOfAfterAdvice(JoinPoint joinPoint) {
		
		System.out.println("After Advice in the method :" + joinPoint.getSignature().toShortString());
	}
	
	@AfterThrowing(pointcut="execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exception")
	public void methodOfAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
		
		System.out.println("AfterThrowing Advice in the method :" + joinPoint.getSignature().toShortString() 
				+ "has the error: " + exception );
	}
	
	
	@AfterReturning(pointcut="execution(* com.oguzhanun.aopdemo.dao.AccountDAO.findAccounts())", returning="result")
	public void afterReturningPointcutMethod(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("AfterReturning Method :" + method);
		
		System.out.println("the result is : " + result);
	}
	
	
	@Before("com.oguzhanun.aopdemo.aspects.MyAspectDemoApp.comboPointcut()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("\nxxx====>>>>BEFOREADDACCOUNTADVICE()<<<====XXX: " + methodSignature);
		
		Object[] arguments = joinPoint.getArgs();
		
		for(Object obj : arguments) {
			
			System.out.println("Method Argument: " + obj);
			
			if(obj instanceof Account){
				Account account = (Account) obj;
				System.out.println("Account Name : " + account.getName());
				System.out.println("Account Level : " + account.getLevel());
			}
		}
	}
	
	
}
