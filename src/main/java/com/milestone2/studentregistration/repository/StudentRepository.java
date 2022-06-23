package com.milestone2.studentregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milestone2.studentregistration.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
