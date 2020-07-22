package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.Course;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;
import com.oguzhanun.hibernate.demo.entity.Review;



public class DeleteCourseandReviewDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
		
			//session.delete(session.get(Review.class, 3));
			
			session.delete(session.get(Course.class, 10));
			//commit the transaction
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
