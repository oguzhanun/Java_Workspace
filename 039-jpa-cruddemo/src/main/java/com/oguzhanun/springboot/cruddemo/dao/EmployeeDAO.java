package com.oguzhanun.springboot.cruddemo.dao;


import java.util.List;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


public interface EmployeeDAO {

	
	public  List<Employee> findAllEmlployee();
	public Employee findEmployee(int id);
	public Employee saveOrUpdateEmployee(Employee employee);
	public int deleteEmployee(int id);

}
