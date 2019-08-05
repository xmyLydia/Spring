package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		// creeate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();
			// create a course
			Course tempCourse = new Course("pacman");

			// add some reviews
			tempCourse.addReview(new Review("Great course"));
			tempCourse.addReview(new Review("Good course"));
			tempCourse.addReview(new Review("Cool course"));
			tempCourse.addReview(new Review("Normal course"));
			// save the course and leverage the cascade.all
			
			System.out.println("tempCourse"+tempCourse);
			System.out.println("tempCourse"+tempCourse.getReviews());
			session.save(tempCourse);
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
