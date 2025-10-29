package com.example.javaproject.controller;

import com.example.javaproject.service.StudentService;
import com.example.javaproject.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }
}

