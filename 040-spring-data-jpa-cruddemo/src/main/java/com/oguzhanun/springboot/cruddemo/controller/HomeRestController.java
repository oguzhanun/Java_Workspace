package com.oguzhanun.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanun.springboot.cruddemo.entity.Employee;
import com.oguzhanun.springboot.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class HomeRestController {
	
	private EmployeeService employeeService;
	
	
	@Autowired
	public HomeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee findEmployee(@PathVariable int employeeId){
		return employeeService.findEmployee(employeeId);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee){
		if(employee.getId() != 0)
			employee.setId(0);
		return employeeService.saveOrUpdateEmployee(employee);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee){
		if(employee.getId() == 0)
			throw new RuntimeException("You should specify the id as a positive integer...");
		return employeeService.saveOrUpdateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "/deletion";
	}

}
