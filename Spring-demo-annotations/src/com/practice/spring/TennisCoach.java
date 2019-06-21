package com.practice.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService fortuneService;
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	//define a default constructor
	public TennisCoach() {
		System.out.println("constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	} 
	 
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println("setter");
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyFortune() {
		 return fortuneService.getFortune();
	}
}
