package com.milestone2.studentregistration.service;

import java.util.List;

import com.milestone2.studentregistration.model.Student;


public interface StudentService {
	
    public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public List<Student> getAllStudentsAscendingOrderbyname();
	
	public List<Student> getAllStudentsAscendingOrderbymarks();
	
	public Student getStudentById(long id);
	
	public Student updateStudent(Student student);
	

	
	void deleteStudentById(long id);
	
	

}
