package com.milestone2.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milestone2.studentregistration.model.Student;
import com.milestone2.studentregistration.service.StudentService;


@RestController
public class StudentController {
	
		@Autowired
		private StudentService studentservice;

		public StudentController(StudentService studentservice) {
			super();
			this.studentservice = studentservice;
		}
		
		
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			return this.studentservice.getAllStudents();
		}
		
		@GetMapping("/students/{id}")
		public Student getemStudentById(@PathVariable("id") String id) {
			return this.studentservice.getStudentById(Long.parseLong(id));
			
		}
		
		@GetMapping("/studentsbyascendingorderbyname")
		public List<Student> getStudentsByAscendingOrderbyname(){
			return studentservice.getAllStudentsAscendingOrderbyname();
		}
 
		@GetMapping("/studentsbyascendingorderbymarks")
		public List<Student> getStudentsByAscendingOrderbymarks(){
			return studentservice.getAllStudentsAscendingOrderbymarks();
		}
		
		
		@PostMapping("/students")
		public ResponseEntity<Student> saveStudent(@RequestBody Student student){
			return new ResponseEntity<Student>(studentservice.saveStudent(student),HttpStatus.CREATED);
		}
		
		
		@PutMapping("/students")
		public Student updateStudent(@RequestBody Student student) {
			return studentservice.updateStudent(student);
		}

			
			@DeleteMapping("/students/{id}")
			public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String id) {
				try {
					this.studentservice.deleteStudentById(Long.parseLong(id));
					return new ResponseEntity<>(HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			
		}

	}
