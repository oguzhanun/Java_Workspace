package com.luv2code.springdemo;



public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today you are very lucky... You get a fortune...";
	}

}
