package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;



public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			System.out.println("transaction begins...");
			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			System.out.println("instructorDetail : " + instructorDetail);
			
			/*EĞER INSTRUCTORDETAIL SINIFINDA INSTRUCTOR FIELD'INDA CASCADE TİPİ DEĞİŞTİRİLİR VE CASCADETYPE.REMOVE ÇIKARILIRSA
			 * BURADA instructorDetail.getInstructor().setInstructorDetail(null) kodunun geçilmesi gerekir ki bu sayede 
			 * database içindeki foreign key null olarak kaydedilsin ve aradaki bağlantı bu şekilde koparılsın... aksi takdirde 
			 * hata mesajı alınır...(EntityNotFoundException)*/
			//!!!!!!!......BURADA EĞER CASCADE TİPİ İKİ TARAF İÇİN DE REMOVE U İÇERMİYORSA KAYNAKLARIN KARŞILIKLI OLARAK SİLİNMESİ GEREKİYOR Kİ 
			//HATA MESAJI ALINMASIN. KAYNAKLARDAN KASIT INSTRUCTOR SINIFI İÇİN COURSES
			// COURSE SINIFI İÇİN INSTRUCTOR...!!!!!!!!
			
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} catch(Exception exc) {
		
			exc.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}