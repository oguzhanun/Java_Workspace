package com.oguzhanun.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationWithoutScanDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigWithoutScan.class);
		
		FootballCoach theCoach = context.getBean("footballCoach",FootballCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.fortuneService.getFortune());
		
		context.close();
	}

}
