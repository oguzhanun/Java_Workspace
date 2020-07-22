package com.oguzhanun.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oguzhanun.springboot.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAllEmlployee() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		//Query<Employee> query = session.createQuery("from Employee where id=:employeeId",Employee.class);
		//query.setParameter("employeeId", id);
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee saveOrUpdateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;
	}

	@Override
	public int deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId",id);
		query.executeUpdate();
		return id;
	}
	
	

}
