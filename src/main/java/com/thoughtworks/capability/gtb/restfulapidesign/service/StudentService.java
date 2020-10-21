package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(Gender gender) {
        return gender == null ? studentRepository.getStudents() : studentRepository.getByGender(gender);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateStudent(int id, Student student) {
        return studentRepository.updateById(id, student);
    }
}
