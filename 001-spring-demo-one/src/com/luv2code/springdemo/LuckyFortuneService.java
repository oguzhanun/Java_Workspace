package com.luv2code.springdemo;

import java.util.Random;

public class LuckyFortuneService implements FortuneService {

	String[] randomFortuneMessage = {"Today is your lucky day... You earned a fortune", 
			"Today is your lucky day in half... You earned a half of fortune",
			"Today is your unlucky day... You earned nothing"};
	
	Random random = new Random();
	
	 
	@Override
	public String getFortune() {
		int i = random.nextInt(3);
		return randomFortuneMessage[i];
		
	}

}
