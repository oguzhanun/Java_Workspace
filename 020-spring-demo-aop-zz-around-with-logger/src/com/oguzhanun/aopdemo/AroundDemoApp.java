package com.oguzhanun.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.oguzhanun.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling getFortune method...\n");
		System.out.println("Today our fortune service says that : " + trafficFortuneService.getFortune() + "\n");
		System.out.println("Finished !!!");
		
		context.close();
	}
}
