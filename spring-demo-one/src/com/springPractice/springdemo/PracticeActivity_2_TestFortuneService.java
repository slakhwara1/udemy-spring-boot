package com.springPractice.springdemo;

public class PracticeActivity_2_TestFortuneService implements FortuneService {
	
	String[] fortuneArray = { "First123 Fortune", "Seconf Fortune", "Third Fortune" };
	
	@Override
	public String getFortune() {
		int randomVal = (int) (Math.random() * 3);
		int itemIndex = randomVal;
		System.out.println("Item index was "+ randomVal);
		return this.fortuneArray[itemIndex];
	}
	
}
