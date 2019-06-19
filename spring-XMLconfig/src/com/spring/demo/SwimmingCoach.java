package com.spring.demo;

public class SwimmingCoach implements Coach{
private FortuneService fortuneService;
	
	 

	public SwimmingCoach(FortuneService fortuneService) {
	super();
	this.fortuneService = fortuneService;
}

	@Override
	public String getDailyWorkout() {
		return "Swim for 1 h everyday";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
