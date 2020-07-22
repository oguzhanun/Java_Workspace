package com.oguzhanun.spring.annotations;

import org.springframework.beans.factory.annotation.Value;

public class FootballCoach implements Coach {

	FortuneService fortuneService;
	
	@Value("${foo.email}")
	String email;
	
	@Value("${foo.team}")
	String team;
	
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "You must be in good shape to be a good footballer... " + team + email ;
	}

}
