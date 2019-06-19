package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean
		Coach theCoach = context.getBean("myCoach",Coach.class);
		//call method
		System.out.println(theCoach.getDailyWorkout());
		//let us call our new method for fortune service
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
	}

}
