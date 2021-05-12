package com.springPractice.springdemo;

public class BaseballCoach implements Coach {


	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService thefortFortuneService) {
		fortuneService = thefortFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
