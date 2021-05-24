package com.springBoot.myApp.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/ ")
	public String getTeamInfo() {
		return "Coach: " + this.coachName + " , Team name: " + this.teamName;
	}

	@GetMapping("")
	public String sayHello() {
		return "Hello World! Time on server is : " + LocalDateTime.now();
	}

}
