package com.oguzhanun.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.StudentDatabase;

public class QueryStudentDemo {

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
			
			System.out.println("//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			System.out.println("email'i ah.com veya duck.com gibi olanları merhaba@merhaba.com'a dönüstür...");
			
			session.createQuery("update StudentDatabase set email= 'merhaba@merhaba.com' where email like '%@ah.com'"
					+ " or email like '%duck.com'").executeUpdate();
			
			StudentDatabase student = (StudentDatabase) session
					.createQuery("from StudentDatabase s where s.firstName = 'veli'")
					.getResultList().get(0);
			student.setFirstName("Veli");
			student.setLastName("kırkdokuzelli");
			
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
