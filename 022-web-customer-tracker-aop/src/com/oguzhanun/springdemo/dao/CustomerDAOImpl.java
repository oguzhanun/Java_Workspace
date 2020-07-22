package com.oguzhanun.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.oguzhanun.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customer = query.getResultList();
		
		return customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		//Customer customer = session.get(Customer.class, id);
		
		
		Query<Customer> query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
		//session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomer(String searchWord) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where firstName "
				+ "like :searchWord or lastName like :searchWord",Customer.class);
		query.setParameter("searchWord", "%"+ searchWord + "%");
		
		return query.getResultList();
	}

}
