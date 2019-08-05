package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// creeate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();
			// get instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);

			System.out.println("LUV2code instructor:" + tempInstructor);
			// get the course

			System.out
					.println("LUV2code course:" + tempInstructor.getCourses());
			// commit transaction
			session.getTransaction().commit();
			// close the sesseion
			session.close();
			System.out
					.println("LUV2code course:" + tempInstructor.getCourses());

			System.out.println("LUV2code Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
