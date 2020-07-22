package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean isTheSame = (theCoach.equals(alphaCoach));
		
		System.out.println("theCoach and alphaCoach are the same objects: " + isTheSame);
		System.out.println("theCoach object's name and address: "+ theCoach);
		System.out.println("alphaCoach object's name and address: "+ alphaCoach);
		
		context.close();
	}

}
