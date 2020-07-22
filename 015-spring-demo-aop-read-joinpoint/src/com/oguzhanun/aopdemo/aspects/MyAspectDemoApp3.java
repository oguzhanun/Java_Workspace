package com.oguzhanun.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyAspectDemoApp3 {

	@Before("com.oguzhanun.aopdemo.aspects.MyAspectDemoApp.comboPointcut()")
	public void performAPIAnalytics() {
		
		System.out.println("xxxxxx===========>>>>>>>>PERFORMEAPIANALYTICS()<<<<<<<<==========XXXXXXXX");
	}
	
	
}
