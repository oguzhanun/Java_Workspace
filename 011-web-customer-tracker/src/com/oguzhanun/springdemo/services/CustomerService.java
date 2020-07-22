package com.oguzhanun.springdemo.services;

import java.util.List;

import com.oguzhanun.springdemo.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();
	
	public void setCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String searchWord);
}
