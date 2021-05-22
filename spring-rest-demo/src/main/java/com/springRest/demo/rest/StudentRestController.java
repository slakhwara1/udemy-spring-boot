package com.springRest.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();

		Student student1 = new Student("John", "Doe");
		Student student2 = new Student("Mary", "Jane");
		Student student3 = new Student("Susan", "Phillips");

		students.add(student1);
		students.add(student2);
		students.add(student3);

		return students;
	}

}
