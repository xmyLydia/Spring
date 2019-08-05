package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class CreateCoursesDemo {

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
			// create courses
			Course tempCourse1 = new Course("Air guitar");
			Course tempCourse2 = new Course("Pinball");
			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			// save the course
			session.save(tempCourse1);
			session.save(tempCourse2);
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
