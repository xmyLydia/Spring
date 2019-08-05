package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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

			// start a transaction
			session.beginTransaction();
			// get the instructor detail object
			int id = 5;

			InstructorDetail tempInstructorDetail = session
					.get(InstructorDetail.class, id);
			// print the instructor detail
			System.out
					.println("temp instructor detail:" + tempInstructorDetail);
			// print the associated instructor
			System.out.println("associated instructor"
					+ tempInstructorDetail.getInstructor());

			// remove associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			// delete instructor detail
			System.out.println("deleteing instructor detail object"
					+ tempInstructorDetail);
			session.delete(tempInstructorDetail);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
