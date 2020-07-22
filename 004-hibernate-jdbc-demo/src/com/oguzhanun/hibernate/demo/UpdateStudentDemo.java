package com.oguzhanun.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.StudentDatabase;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentDatabase.class)
				.buildSessionFactory();
	
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
		
			//start a transaction
			session.beginTransaction();
			
			List<StudentDatabase> students = session.createQuery("from StudentDatabase").getResultList();
			
			showStudent(students);
			
			List<StudentDatabase> aliler = session.createQuery("from StudentDatabase s where s.firstName = 'ali '")
					.getResultList();
			
			showStudent(aliler);
			
			System.out.println("//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			
			List<StudentDatabase> ahcomlar = session.createQuery("from StudentDatabase s where s.email like '%@ah.com'"
					+ " or s.email like '%duck.com'").getResultList();
			
			showStudent(ahcomlar);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
	}

	private static void showStudent(List<StudentDatabase> students) {
		for(StudentDatabase sd : students) {
			System.out.println(sd);
		}
	}

}
