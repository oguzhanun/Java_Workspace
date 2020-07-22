package com.oguzhanun.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.oguzhanun.aopdemo.service.TrafficFortuneService;


public class AroundWithLoggerDemoApp {
	
	
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Calling getFortune method...\n");
		logger.info("Today our fortune service says that : " + trafficFortuneService.getFortune() + "\n");
		logger.info("Finished !!!");
		
		context.close();
	}
}
