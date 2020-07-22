package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;



public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		InstructorDetail instructorDetail1 = new InstructorDetail("www.oguzhanun.youtube.com","writing code");
		
		Instructor instructor1 = new Instructor("oguzhan","un","oguzhanun@hotmail.com");
		instructor1.setInstructorDetail(instructorDetail1);
		
		
		InstructorDetail instructorDetail2 = new InstructorDetail("www.moguzhanun.youtube.com","writing poem");
		
		Instructor instructor2 = new Instructor("mustafa","un","moguzhanun@gmail.com");
		instructor2.setInstructorDetail(instructorDetail2);
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			session.save(instructor1);
			session.save(instructor2);
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
