package com.example.javaproject.service;

import com.example.javaproject.entity.Student;
import com.example.javaproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Save or update student
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    // Find student by ID
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepo.findById(id);
        return optional.orElse(null);
    }

    // Delete student
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
