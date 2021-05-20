package com.springPractice.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.springPractice.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Doing my DB work: adding an account");
	}

	public boolean doWork() {
		System.out.println(getClass() + " : doWork()");
		return true;
	}

}
