package com.oguzhanun.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Account {
	
	private String name;
	
	private String level;

	public static List<Account> accounts = new ArrayList<>();
	
	public Account() {
		
	}

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
		accounts.add(this);
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	
	
}
