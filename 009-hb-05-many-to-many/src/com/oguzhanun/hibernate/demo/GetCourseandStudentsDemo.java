package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.Course;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;
import com.oguzhanun.hibernate.demo.entity.Review;
import com.oguzhanun.hibernate.demo.entity.Student;



public class GetCourseandStudentsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
	
			Student student = session.get(Student.class, 22);
		
			
			session.delete(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
	}
}







