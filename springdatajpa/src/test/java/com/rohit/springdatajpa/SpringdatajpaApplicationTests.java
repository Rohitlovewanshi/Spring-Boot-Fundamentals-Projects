package com.rohit.springdatajpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rohit.springdatajpa.entities.Student;
import com.rohit.springdatajpa.repos.StudentRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;

	@Test
	void contextLoads() {
		Student student = new Student();
		student.setId(1L);
		student.setName("Rohit");
		student.setTestScore(100);
		repository.save(student);
		
		Student savedStudent = repository.getById(1L);
		Assertions.assertNotNull(savedStudent);
	}

}
