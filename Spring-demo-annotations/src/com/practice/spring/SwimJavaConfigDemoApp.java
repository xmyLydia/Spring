package com.practice.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		SwimmmingCoach coach = context.getBean("swimmingCoach", SwimmmingCoach.class);
		//all a method on the bean
		//System.out.println(coach.getDailyWorkout());
		//call method to get daily fortune
		System.out.println(coach.getDailyFortune());
		//call our new swim coach method has the props
		System.out.println("email:"+coach.getEmail());
		System.out.println("team:"+coach.getTeam());
		//close the context
		context.close();
	}

}
