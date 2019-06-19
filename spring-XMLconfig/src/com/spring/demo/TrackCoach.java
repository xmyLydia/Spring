package com.spring.demo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		 
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() { 
		return "Just do it:"+fortuneService.getFortune();
	}
	
	//add an init method
	public void doMystartupSturff() {
		System.out.println("Inside init");
	}
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Inside destroy");
	}
}
