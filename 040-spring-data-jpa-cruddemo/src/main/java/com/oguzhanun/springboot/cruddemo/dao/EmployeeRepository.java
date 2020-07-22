package com.oguzhanun.springboot.cruddemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.oguzhanun.springboot.cruddemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
