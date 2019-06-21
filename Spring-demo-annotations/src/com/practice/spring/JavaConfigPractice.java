package com.practice.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigPractice {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context 
		 		= new AnnotationConfigApplicationContext(NewSportConfig.class);
		 //retrieve bean
		Coach coach = context.getBean("walkingCoach",Coach.class);
		System.out.println(coach.getDailyFortune());
	}

}
