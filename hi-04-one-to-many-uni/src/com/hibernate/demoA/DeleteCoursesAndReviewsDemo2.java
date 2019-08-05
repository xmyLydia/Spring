package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class DeleteCoursesAndReviewsDemo2 {

	public static void main(String[] args) {
		// creeate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// get the course
			int id = 10;
			Course course = session.get(Course.class, id);
			
			// print the course
			System.out.println(course);
			
			// print the course reviews
			System.out.println(course.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			
			// commit transaction
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
