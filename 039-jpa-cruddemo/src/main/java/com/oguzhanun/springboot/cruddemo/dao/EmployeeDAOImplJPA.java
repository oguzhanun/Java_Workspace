package com.oguzhanun.springboot.cruddemo.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.oguzhanun.springboot.cruddemo.entity.Employee;

//@Primary ile birden fazla EmployeeDAO interface ini implement eden varsa bunu çalıştır diyoruz...
@Primary
@Repository
public class EmployeeDAOImplJPA implements EmployeeDAO {

	private EntityManager entityManager;
	
	
	public EmployeeDAOImplJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAllEmlployee() {
		Query query= entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee saveOrUpdateEmployee(Employee employee) {
		
		// burada hibernate ten önemli bir fark var. o da şu ki 
		// hibernate saveOrUpdate metodundan sonra geriye entity döndürmüyor.
		// ama merge döndürüyor. Buradan yeni kaydın id si de bulunabiliyor.
		return entityManager.merge(employee); 
		
	}

	@Override
	public int deleteEmployee(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		return id;
	}

}
