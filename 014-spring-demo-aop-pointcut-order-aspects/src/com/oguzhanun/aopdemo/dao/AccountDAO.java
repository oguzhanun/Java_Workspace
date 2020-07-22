package com.oguzhanun.aopdemo.dao;

import org.springframework.stereotype.Repository;
import com.oguzhanun.aopdemo.Account;


@Repository
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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
