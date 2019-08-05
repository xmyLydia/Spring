package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", id);
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("LUV2code instructor:" + tempInstructor);
			 

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
