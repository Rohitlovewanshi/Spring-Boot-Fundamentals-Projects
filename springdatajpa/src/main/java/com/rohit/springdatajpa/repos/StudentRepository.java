package com.rohit.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
