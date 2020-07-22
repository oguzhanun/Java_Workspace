package com.oguzhanun.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oguzhanun.aopdemo.Account;


@Repository
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	List<Account> accounts;
	
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("No more soup for you!!!");
		}
		
		Account account1 = new Account("ali","gold");
		Account account2 = new Account("johnny", "platin");
		Account account3 = new Account("farrah", "silver");
		
		accounts = new ArrayList<>();
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean vipPerson) {
		
		System.out.println(getClass() + ": DOING MY DB WORK. ADDING AN ACCOUNT...");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": goToSleep()");
	}
	
}
