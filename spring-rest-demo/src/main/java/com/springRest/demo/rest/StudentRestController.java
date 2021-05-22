package com.springRest.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		this.students = this.getLocalStudentList();
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return this.students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId < 0 || studentId >= this.students.size()) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return this.students.get(studentId);
	}

	private List<Student> getLocalStudentList() {
		List<Student> students = new ArrayList<Student>();

		Student student1 = new Student(1, "John", "Doe");
		Student student2 = new Student(2, "Mary", "Jane");
		Student student3 = new Student(3, "Susan", "Phillips");

		students.add(student1);
		students.add(student2);
		students.add(student3);

		return students;

	}

}
