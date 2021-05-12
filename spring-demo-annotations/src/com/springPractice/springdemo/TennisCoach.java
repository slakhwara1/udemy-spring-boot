package com.springPractice.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortunrService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortunrService = fortuneService;
//	}
	
	public TennisCoach() {
		System.out.println(">> inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> Tennis Coach : Inside doMyStartupStuff ");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> Tennis Coach : Inside doMyCleanupStuff ");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your bacnhand volley";
	}

//	@Autowired
//	public void setFortunrService(FortuneService fortunrService) {
//		System.out.println(">> inside setFortunrService");
//		this.fortunrService = fortunrService;
//	}

	@Override
	public String getDailyFortune() {
		return fortunrService.getFortune();
	}

}
