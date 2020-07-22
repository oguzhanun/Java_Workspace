package com.oguzhanun.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Do what your swimcoach says....";
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	

}
