package com.practice.spring;

import org.springframework.beans.factory.annotation.Value;

public class SwimmmingCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimmmingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() { 
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
