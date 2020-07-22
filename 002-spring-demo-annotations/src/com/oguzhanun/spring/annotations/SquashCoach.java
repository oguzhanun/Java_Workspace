package com.oguzhanun.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class SquashCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Squash is kind of sport that demands hard work...";
	}

}
