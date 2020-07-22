package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.Course;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;



public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	
		InstructorDetail instructorDetail1 = new InstructorDetail("www.oguzhanun.youtube.com","writing code");
		
		Instructor instructor1 = new Instructor("oguzhan","un","oguzhanun@hotmail.com");
		instructor1.setInstructorDetail(instructorDetail1);
		
		
		InstructorDetail instructorDetail2 = new InstructorDetail("www.moguzhanun.youtube.com","writing poem");
		
		Instructor instructor2 = new Instructor("mustafa","un","moguzhanun@gmail.com");
		instructor2.setInstructorDetail(instructorDetail2);
		
		Course course1 = new Course("java kursu");
		Course course2 = new Course("python kursu");
		Course course3 = new Course("c# kursu");
		
		course1.setInstructor(instructor1);
		course2.setInstructor(instructor1);
		course3.setInstructor(instructor2);
		
		instructor1.setCourses(course1);
		instructor1.setCourses(course2);
		instructor2.setCourses(course3);
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			session.save(instructor2);
			session.save(instructor1);
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			/*Instructor instructor = (Instructor) session.createQuery("from Instructor i where i.firstName='un'").getResultList().get(0);
			instructor.setFirstName("oguzhan");
			instructor.setLastName("un");
			//session.save(instructor);
			*/
			
			//commit the transaction
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
