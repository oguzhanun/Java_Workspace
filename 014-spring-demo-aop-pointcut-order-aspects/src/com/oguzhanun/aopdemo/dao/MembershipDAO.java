package com.oguzhanun.aopdemo.dao;

import org.springframework.stereotype.Repository;


@Repository
public class MembershipDAO {

	//public void addSillyMember() {
	public boolean addSillyMember() {
		
		System.out.println(getClass() + ": Burası MembershipDAO sınıfının addAccount metodu....");
		
		return true;
	}
	
	public void doWork() {
		
		System.out.println(getClass() + ": doWork()");
	}

}
