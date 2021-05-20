package com.springPractice.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springPractice.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();

		Account account1 = new Account("John", "Silver");
		Account account2 = new Account("Madhu", "Platinum");
		Account account3 = new Account("Luca", "Gold");

		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		return accounts;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Doing my DB work: adding an account");
	}

	public boolean doWork() {
		System.out.println(getClass() + " : doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
