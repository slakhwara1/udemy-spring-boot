package com.springAppRest.jackson.demo.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			ObjectMapper mapper = new ObjectMapper();

//			Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println(
					"\n First Name : " + theStudent.getFirstName() + " Last Name : " + theStudent.getLastName());

			Address tempAddress = theStudent.getAddress();

			System.out.println("\n State : " + tempAddress.getState());
			System.out.println("\n Street : " + tempAddress.getCity());
			
			System.out.println("Languages : " + theStudent.getLanguages());

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
