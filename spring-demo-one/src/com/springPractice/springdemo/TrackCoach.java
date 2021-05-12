package com.springPractice.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it" + fortuneService.getFortune();
	}
	
	public void doSomeStartupStuff() {
		System.out.println("TrackCoach: inside method doSomeStartupStuff");
	}

	public void doSomeCleanupStuff() {
		System.out.println("TrackCoach: inside method doSomeCleanupStuff");
	}
}
