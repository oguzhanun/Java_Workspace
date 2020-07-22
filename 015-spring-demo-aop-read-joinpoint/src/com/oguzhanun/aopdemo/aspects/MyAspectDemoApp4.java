package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class MyAspectDemoApp4 {

	@Before("com.oguzhanun.aopdemo.aspects.MyAspectDemoApp.comboPointcut()")
	public void performFunnyThings() {
		
		System.out.println("xxxxxx===========>>>>>>>> PERFORMEFUNNYTHINGS()<<<<<<<<==========XXXXXXXX");
	}
	
	
}
