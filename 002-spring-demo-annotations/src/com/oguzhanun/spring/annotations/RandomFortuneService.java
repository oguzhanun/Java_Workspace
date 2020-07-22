package com.oguzhanun.spring.annotations;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class RandomFortuneService implements FortuneService {

	@Value("${foo.fortunesString}")
	private String fortunesString;
	
	String[] fortunes;
	
	int i;
	Random random = new Random();

	@Override
	public String getFortune() {
		i = random.nextInt(fortunes.length);
		return fortunes[i];
	}
	
	@PostConstruct
	public void setArray() {
		fortunes = fortunesString.split(",\\s*");
	}

}
