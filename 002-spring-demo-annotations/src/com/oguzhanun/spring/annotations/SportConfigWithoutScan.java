package com.oguzhanun.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfigWithoutScan {
	
	@Bean
	public FortuneService fortuneService() {
		return new SadFortuneServices();
	}
	
	@Bean
	public Coach footballCoach() {
		return new FootballCoach(fortuneService());
	}

}
