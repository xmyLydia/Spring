package com.practice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewSportConfig {
	@Bean
	public FortuneService singleFortune() {
		return new SingleFortune();
	}
	
	@Bean
	public Coach walkingCoach( ) {
	 return new WalkingCoach(singleFortune());	
	}

}
