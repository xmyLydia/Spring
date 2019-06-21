package com.practice.spring;

public class WalkingCoach implements Coach {

	FortuneService singleFortune;
	
	public WalkingCoach(FortuneService singleFortune) {
	 this.singleFortune = singleFortune;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		return singleFortune.getFortune();
	}

}
