package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class AddCoursesForMaryDemo {

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

			// get the student mary from db
			int id = 2;
			Student tempStudent = session.get(Student.class, id);
			System.out.println("student:" + tempStudent);
			System.out.println("course:"+tempStudent.getCourses());
			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube");
			Course tempCourse2 = new Course("Atari 2600 - game development");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("saving the course");
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
