package com.luv2code.springdemo;



public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	public void theCoachInitializationMethod() {
		System.out.println("TrackCoach: " + "Initialization acheived...");
	}
	
	public void theCoachDestroyMethod() {
		System.out.println("TrackCoach: " + "Destroying acheived...");
	}
}
