package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspectDemoApp {

	//@Before("execution(public void com.oguzhanun.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution( void add*())")
	//@Before("execution( * add*())")
	//@Before("execution( * add*(com.oguzhanun.aopdemo.Account))")
	//@Before("execution( * add*(com.oguzhanun.aopdemo.Account, ..))")
	//@Before("execution( * add*(..))")
	@Before("execution( * com.oguzhanun.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		
		System.out.println("xxxxxx===========>>>>>>>> @BEFORE DO IT NOW. OK. DID YOU UNDERSTAND ME<<<<<<<<==========XXXXXXXX");
	}
}
