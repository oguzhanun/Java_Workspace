package com.luv2code.springdemo;



public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		//System.out.println("setEmailAddress is visited...");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		//System.out.println("setTeam is visited...");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Cricket requires discipline...!!!";
	}
	
	@Override
	public String getFortune() {

		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	

}
