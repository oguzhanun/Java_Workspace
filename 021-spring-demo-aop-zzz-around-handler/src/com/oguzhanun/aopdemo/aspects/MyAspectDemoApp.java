package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class MyAspectDemoApp {

	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.*(..))")
	public void pointcutExpression() {}
	
	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.get*(..))")
	public void getterPointcut() {}
	
	@Pointcut("execution(* com.oguzhanun.aopdemo.dao.*.set*(..))")
	public void setterPointcut() {}
	
	@Pointcut("pointcutExpression() && !(getterPointcut() || setterPointcut())")
	public void comboPointcut() {}
	
	
}
