package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.StudentDatabase;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentDatabase.class)
				.buildSessionFactory();
	
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
		
			//create a student object
			System.out.println("Creating the student object...");
			StudentDatabase student = new StudentDatabase("Jhon", "Doe", "jhondoe@jhondoe.com" );
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object to the session
			System.out.println("Saving the student object to the session");
			System.out.println(student);
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			
			sessionFactory.close();
		}
		
	}

}
