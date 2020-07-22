package com.luv2code.springdemo;



public class SoccerCoach implements Coach {

	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "SoccerCoach is the best coach ever";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
