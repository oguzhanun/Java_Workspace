package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
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
