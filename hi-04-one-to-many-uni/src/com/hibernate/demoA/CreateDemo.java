package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// creeate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create the objects
			/*Instructor tempInstructor = new Instructor("Chad", "Darby",
					"darby@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.luv2code.com", "luv 2 code!");
					*/
			Instructor tempInstructor = new Instructor("mingyue", "xie",
					"mingyux@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.luv2code.com", "luv 2 think!");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			// start a transaction
			session.beginTransaction();
			// save the instructor
			System.out.println("saving instructor" + tempInstructor);
			session.save(tempInstructor);
			session.close();
			// commit transaction
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
