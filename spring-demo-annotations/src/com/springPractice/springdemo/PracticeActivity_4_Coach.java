package com.springPractice.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PracticeActivity_4_Coach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice coding daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
