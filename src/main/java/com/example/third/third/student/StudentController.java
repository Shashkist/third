package com.example.third.third.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/student")
    public List student() {
       return studentService.hi();
    }

    @PostMapping("/")
    public void registerNewStudent(@RequestBody Student student) {
        Student  studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail != null) {
            throw new IllegalStateException("email taken");
        }
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        Student  studentById = studentRepository.findStudentById(id);
        if (studentById == null) {
            throw new IllegalStateException("such id doesn't exists taken");
        }
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {

        studentService.updateStudent(name,email, studentId);
    }
}
