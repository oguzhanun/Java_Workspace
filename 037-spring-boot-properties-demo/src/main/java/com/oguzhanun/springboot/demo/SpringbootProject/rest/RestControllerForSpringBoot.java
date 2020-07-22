package com.oguzhanun.springboot.demo.SpringbootProject.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestControllerForSpringBoot {

	
	@Value("${coach.name}")
	private String coach;
	
	@Value("${team.name}")
	private String team;
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World of SpringBoot";
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 15K today";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		
		return "Your Lucky day! You got a fortune";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "The Coach is: " + coach + " and The Team is: " + team;
	}
	
}
