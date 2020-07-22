package com.oguzhanun.springboot.cruddemo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzhanun.springboot.cruddemo.dao.EmployeeDAOImpl;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAOImpl employeeDAOImpl;
	
	
	@Autowired
	public EmployeeServiceImpl (EmployeeDAOImpl employeeDAOImpl) {
		this.employeeDAOImpl = employeeDAOImpl;
	}
	
	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		return employeeDAOImpl.findAllEmlployee();
	}

	@Override
	@Transactional
	public Employee findEmployee(int id) {
		return employeeDAOImpl.findEmployee(id);
	}

	@Override
	@Transactional
	public Employee saveOrUpdateEmployee(Employee employee) {
		return employeeDAOImpl.saveOrUpdateEmployee(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		return employeeDAOImpl.deleteEmployee(id);
	}

}
