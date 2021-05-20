package com.springPractice.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Expect heavy traffic this morning";

	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Major Accident! Highway is closed");
		}

		return this.getFortune();
	}

}
