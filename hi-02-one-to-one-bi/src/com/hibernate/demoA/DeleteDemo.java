package com.hibernate.demoA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class DeleteDemo {

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
			//get instructor by primary key
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found instructor"+tempInstructor);
			//delete the inscturcot
			if(tempInstructor !=null) {
				//will also delete associated instructorDetail
				//because of cascadeType.All
				session.delete(tempInstructor);
			}
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
