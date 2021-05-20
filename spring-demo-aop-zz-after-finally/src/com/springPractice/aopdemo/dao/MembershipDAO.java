package com.springPractice.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addSillyMember() {
		System.out.println(getClass() + " Doing my DB work: adding an account");
		return null;
	}

	public void goTosleep() {
		System.out.println(getClass() + " : goTosleep()");
	}

}
