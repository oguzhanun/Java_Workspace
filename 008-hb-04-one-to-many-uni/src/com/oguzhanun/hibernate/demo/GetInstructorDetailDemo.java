package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;



public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			System.out.println("transaction begins...");
			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2999999);
			System.out.println("instructorDetail : " + instructorDetail);
			System.out.println("instructor : " + instructorDetail.getInstructor());
			
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} catch(Exception exc) {
		
			exc.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}