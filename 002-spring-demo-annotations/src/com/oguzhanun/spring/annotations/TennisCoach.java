package com.oguzhanun.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired//Sadece buraya autowired yazarak field'ın içini doldurabiliyoruz.
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	//@Autowired
	public TennisCoach() { //public TennisCoach ( @Qualifire("interface'i imlement eden sınıflardan hangisini istiyorsak buraya yazıyoruz")FortuneService fortuneService){
		//this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	@PostConstruct
	public void doSomethingFirst() {
		System.out.println("This is the thing done at first hand");
	}
	
	@PreDestroy
	public void doSomethingLast() {
		System.out.println("This is the thing done at last");
	}
	
	/*
	@Autowired
	public void doSomeCrazyThings(FortuneService fortuneService) {//setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
}
