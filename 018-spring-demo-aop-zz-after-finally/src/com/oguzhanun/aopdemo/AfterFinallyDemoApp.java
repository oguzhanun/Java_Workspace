package com.oguzhanun.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oguzhanun.aopdemo.dao.AccountDAO;


public class AfterFinallyDemoApp {
	
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		List<Account> accounts = null;
		
		try {
			boolean tripWire = false;
			
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Accounts are listed as: " + accounts);
		
		System.out.println(Account.accounts);
		/*new Account("ali","aldk");
		new Account("aadf","aldk");
		new Account("adgbb","aldk");
		new Account("apoklakojd","aldk");
		
		List<Account> accounts = new Account().getAccounts();
		boolean empty = accounts.isEmpty();
		
		System.out.println(accounts);*/
		
		context.close();
	}
}
