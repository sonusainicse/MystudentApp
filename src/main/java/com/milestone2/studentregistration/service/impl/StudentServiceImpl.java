package com.milestone2.studentregistration.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.milestone2.studentregistration.model.Student;
import com.milestone2.studentregistration.repository.StudentRepository;
import com.milestone2.studentregistration.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
private	StudentRepository studentRepository ;

	public StudentServiceImpl(StudentRepository studentRepository) {
	super();
	this.studentRepository = studentRepository;
}
	@Override
   	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		 return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		java.util.Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException(" Student not found for id :: " + id);
		}
		return student;
	}
	
	
	@Override
	public List<Student> getAllStudentsAscendingOrderbyname() {
		List<Student> list = studentRepository.findAll();

		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}

		});

		return list;
	}

	
	@Override
	public List<Student> getAllStudentsAscendingOrderbymarks() {
		List<Student> list = studentRepository.findAll();

		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getMarks()-s2.getMarks();
			}

		});

		return list;
	}
	
	// to update the student
	public Student updateStudent(Student student) {
		Student ExistingStudent = studentRepository.findById(student.getId()).orElse(null);
		ExistingStudent.setFirstName(student.getFirstName());
		ExistingStudent.setLastName(student.getLastName());
		ExistingStudent.setMarks(student.getMarks());
		return studentRepository.save(ExistingStudent);
	}


	@Override
	public void deleteStudentById(long id) {
		this.studentRepository.deleteById(id);
	}


}
