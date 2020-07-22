package com.oguzhanun.springboot.cruddemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzhanun.springboot.cruddemo.dao.EmployeeRepository;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository ;
	
	
	@Autowired
	public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployee(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("no such entity found with the id of" + id);
		}
		
		return employee;
	}

	@Override
	@Transactional
	public Employee saveOrUpdateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return id;
	}

}
