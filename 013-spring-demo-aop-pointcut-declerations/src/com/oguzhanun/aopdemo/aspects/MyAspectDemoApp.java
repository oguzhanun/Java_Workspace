package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspectDemoApp {

	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.*(..))")
	private void pointcutExpression() {}
	
	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.get*(..))")
	private void getterPointcut() {}
	
	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.set*(..))")
	private void setterPointcut() {}
	
	@Pointcut("pointcutExpression() && !(getterPointcut() || setterPointcut())")
	private void comboPointcut() {}
	
	//@Before("execution(public void com.oguzhanun.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution( void add*())")
	//@Before("execution( * add*())")
	//@Before("execution( * add*(com.oguzhanun.aopdemo.Account))")
	//@Before("execution( * add*(com.oguzhanun.aopdemo.Account, ..))")
	//@Before("execution( * add*(..))")
	//@Before("execution( * com.oguzhanun.aopdemo.dao.*.*(..))")
	//@Before("pointcutExpression()")
	@Before("comboPointcut()")
	@Order(2) //çalışmadı bu şekilde.... order ın sınıfa verimesi gerekiyor sanırım. yani dolayısıyla buradaki methodlar bölünmeli...
	public void beforeAddAccountAdvice() {
		//performAPIAnalytics();
		System.out.println("xxxxxx===========>>>>>>>> @BEFORE BEFOREADDACCOUNTADVICE()<<<<<<<<==========XXXXXXXX");
	}
	
	//@Before("pointcutExpression()")
	@Before("comboPointcut()")
	@Order(1)
	public void performAPIAnalytics() {
		
		System.out.println("xxxxxx===========>>>>>>>> @BEFORE PERFORMEAPIANALYTICS()<<<<<<<<==========XXXXXXXX");
	}
	
	
}
