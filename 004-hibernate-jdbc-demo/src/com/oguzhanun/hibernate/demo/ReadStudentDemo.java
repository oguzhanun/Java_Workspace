package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.StudentDatabase;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(StudentDatabase.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
	
		StudentDatabase student4 = new StudentDatabase("Daffy","Duck", "daffy@duck.com");

		try {
			session.beginTransaction();
			session.save(student4);
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			StudentDatabase myStudent = session.get(StudentDatabase.class, student4.getId());
			
			System.out.println(myStudent);
			
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
	}

}
