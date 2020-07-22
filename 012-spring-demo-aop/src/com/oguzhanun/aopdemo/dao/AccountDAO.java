package com.oguzhanun.aopdemo.dao;

import org.springframework.stereotype.Repository;
import com.oguzhanun.aopdemo.Account;


@Repository
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipPerson) {
		
		System.out.println(getClass() + ": DOING MY DB WORK. ADDING AN ACCOUNT...");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": goToSleep()");
	}
	
}
