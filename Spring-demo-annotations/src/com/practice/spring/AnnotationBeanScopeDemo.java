package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		//load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result = (coach==alphaCoach);
		System.out.println("the same"+result);
		System.out.println("memory location:"+coach);
		System.out.println("memory location:"+alphaCoach);
		//close the context
		context.close();
	}

}
