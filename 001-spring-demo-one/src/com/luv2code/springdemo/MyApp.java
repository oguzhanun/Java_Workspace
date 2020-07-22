package com.luv2code.springdemo;



public class MyApp {

	public static void main(String[] args) {
		
		FortuneService fortuneService = new HappyFortuneService();
		
		//create the object 
		Coach theCoach = new TrackCoach(fortuneService);
		
		//use the object
		System.out.println(theCoach.getDailyWorkout() +" :----: "+ theCoach.getFortune());
	}

}
