package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.StudentDatabase;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
	
	
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentDatabase.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		StudentDatabase student1 = new StudentDatabase("Ali", "Hasan","ah@ah.com");
		StudentDatabase student2 = new StudentDatabase("Mehmet", "Hasan","mah@ah.com");
		StudentDatabase student3 = new StudentDatabase("Cengiz", "Hasan","ch@ah.com");
		
		try {
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
	}

}
