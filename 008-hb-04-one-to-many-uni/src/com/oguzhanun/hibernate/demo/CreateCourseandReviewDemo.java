package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.Course;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;
import com.oguzhanun.hibernate.demo.entity.Review;



public class CreateCourseandReviewDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	
		Course course1 = new Course("Pacman-How to score one million points");
		
		course1.AddReview(new Review("Good Job... Well Done!!!"));
		course1.AddReview(new Review("Hey body come on! What the what!"));
		course1.AddReview(new Review("Yeah, I liked that"));
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
		
			session.save(course1);
			
			//commit the transaction
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
