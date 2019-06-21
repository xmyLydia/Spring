package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//get the bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		//all a method on the bean
		//System.out.println(coach.getDailyWorkout());
		//call method to get daily fortune
		System.out.println(coach.getDailyFortune());
		//close the context
		context.close();
	}

}
