package com.luv2code.springdemo;



public class BaseballCoach implements Coach{
	
	FortuneService fortuneService;
	
	
	
	public BaseballCoach() {
		super();
		//this.fortuneService = theFortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting pracice";
	}

	public FortuneService setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		return this.fortuneService;
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}
	
	

}
