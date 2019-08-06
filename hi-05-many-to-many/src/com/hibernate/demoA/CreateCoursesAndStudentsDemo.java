package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			// create a course
			Course tempCourse = new Course("pacman");
			// save the course
			session.save(tempCourse);
			// create students
			Student tempStudent1 = new Student("John", "Doe",
					"test1@gmail.com");
			Student tempStudent2 = new Student("Mary", "Test",
					"test2@gmail.com");
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			// save the students
			System.out.println("save the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
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
