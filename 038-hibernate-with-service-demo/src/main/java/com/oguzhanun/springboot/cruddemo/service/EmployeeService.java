package com.oguzhanun.springboot.cruddemo.service;

import java.util.List;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> findAllEmployee();
	public Employee findEmployee(int id);
	public Employee saveOrUpdateEmployee(Employee employee);
	public int deleteEmployee(int id);

}
