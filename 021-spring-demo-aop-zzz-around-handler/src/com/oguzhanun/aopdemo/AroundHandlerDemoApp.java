package com.oguzhanun.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.oguzhanun.aopdemo.service.TrafficFortuneService;


public class AroundHandlerDemoApp {
	
	
	private static Logger logger = Logger.getLogger(AroundHandlerDemoApp.class.getName());
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		boolean tripWire = false;
		
		logger.info("Calling getFortune method...\n");
		logger.info("Today our fortune service says that : " + trafficFortuneService.getFortune(tripWire) + "\n");
		logger.info("Finished !!!");
		
		context.close();
	}
}
