package com.StudentManagementApp.controller;

import com.StudentManagementApp.model.Student;
import com.StudentManagementApp.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")  // Allow frontend calls
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Search student by roll number
    @GetMapping("/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo) {
        Optional<Student> student = repo.findByRollNo(rollNo);
        return student.orElse(null);
    }
}
