package com.oguzhanun.hibernate.homework;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class EmployeeDemo {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Employee employee1 = new Employee("ali", "cengiz",new Date(),"alicengizCompany");
		Employee employee2 = new Employee("ali", "cengiz",new Date(),"alicengizCompany");
		Employee employee3 = new Employee("ali", "cengiz",new Date(),"alicengizCompany");
		Employee employee4 = new Employee("ali", "cengiz",new Date(),"alicengizCompany");
		Employee employee5 = new Employee("ali", "cengiz",new Date(),"alicengizCompany");
		
		try {
			
			System.out.println("transaction başlıyor....");
			
			session.beginTransaction();
		
			session.saveOrUpdate(employee1);
			session.saveOrUpdate(employee2);
			session.saveOrUpdate(employee3);
			session.saveOrUpdate(employee4);
			session.saveOrUpdate(employee5);
			
			session.getTransaction().commit();
			
			System.out.println("transaction bitti....");
			
		} finally {
			sessionFactory.close();
		}
		
	}

}
