package com.oguzhanun.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.oguzhanun.aopdemo.dao.AccountDAO;
import com.oguzhanun.aopdemo.dao.MembershipDAO;


public class MainDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.addAccount(new Account(), true);
		accountDAO.goToSleep();
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		membershipDAO.addSillyMember();
		membershipDAO.doWork();
		
		context.close();
	}
}
