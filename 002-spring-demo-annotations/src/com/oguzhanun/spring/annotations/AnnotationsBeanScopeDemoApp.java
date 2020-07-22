package com.oguzhanun.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println("Are the coachs same: " + (theCoach == alphaCoach));
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		
		context.close();
		
	}

}
