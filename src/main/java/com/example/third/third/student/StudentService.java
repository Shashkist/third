package com.example.third.third.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List hi() {
        List<Student> allStudents = studentRepository.findAll();


        return allStudents;
    }

    public void addNewStudent(Student student) {
//        System.out.println(student);


        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(String name, String email, Long studentId) {
        Student  studentById = studentRepository.findStudentById(studentId);
        if (studentById == null) {
            throw new IllegalStateException("such id doesn't exists taken");
        }
        if (name != null && name.length() > 0) {
            studentById.setName(name);
        }
        if (email != null && email.length() > 0) {
            Student  studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail != null) {
                throw new IllegalStateException("email taken");
            }
            studentById.setEmail(email);
        }

    }
}
