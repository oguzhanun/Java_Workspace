package com.oguzhanun.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read the spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class );
		Coach squashCoach = context.getBean("squashCoach",Coach.class);
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on  the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(squashCoach.getDailyWorkout());
		System.out.println(theCoach.getFortuneService().getFortune());
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getFortuneService().getFortune());
		//close the context
		context.close();
		
	}

}
