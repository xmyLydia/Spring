package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {
		// creeate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			 int studentId = 2;
			 Student tempStudent = session.get(Student.class, studentId);
			 System.out.println("delete");
			 session.delete(tempStudent);
		 
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
