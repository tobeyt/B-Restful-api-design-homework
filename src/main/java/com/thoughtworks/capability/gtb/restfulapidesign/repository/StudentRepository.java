package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private int id = 3;
    private final List<Student> students = new ArrayList<Student>() {
        {
            add(new Student(1, "覃狄1", Gender.MALE, "TWer"));
            add(new Student(2, "覃狄2", Gender.MALE, "TWer"));
            add(new Student(3, "覃狄3", Gender.FEMALE, "TWer"));
        }
    };

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        student.setId(getStudentId());
        students.add(student);
        return student;
    }

    public void deleteById(int id) {
        students.remove(findById(id));
    }

    public List<Student> getByGender(Gender gender) {
        return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student findById(int id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst()
                .orElseThrow(() -> new StudentException("用户不存在"));
    }

    public Student updateById(int id, Student student) {
        Student studentFindById = findById(id);
        students.remove(studentFindById);
        studentFindById.setName(student.getName());
        studentFindById.setGender(student.getGender());
        studentFindById.setNote(student.getNote());
        students.add(studentFindById);
        return studentFindById;
    }

    public List<Student> getShuffledStudents() {
        ArrayList<Student> newStudents = new ArrayList<>(this.students);
        Collections.shuffle(newStudents);
        return newStudents;
    }

    private Integer getStudentId() {
        return ++id;
    }
}
