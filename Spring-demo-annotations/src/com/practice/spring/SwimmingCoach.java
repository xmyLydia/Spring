package com.practice.spring;

import org.springframework.stereotype.Component;

@Component("Swim")
public class SwimmingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Swim 1 hour every day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
