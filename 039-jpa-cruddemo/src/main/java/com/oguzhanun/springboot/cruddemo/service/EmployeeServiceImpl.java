package com.oguzhanun.springboot.cruddemo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzhanun.springboot.cruddemo.dao.EmployeeDAO;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeServiceImpl (@Qualifier("employeeDAOImplJPA") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		return employeeDAO.findAllEmlployee();
	}

	@Override
	@Transactional
	public Employee findEmployee(int id) {
		return employeeDAO.findEmployee(id);
	}

	@Override
	@Transactional
	public Employee saveOrUpdateEmployee(Employee employee) {
		return employeeDAO.saveOrUpdateEmployee(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

}
