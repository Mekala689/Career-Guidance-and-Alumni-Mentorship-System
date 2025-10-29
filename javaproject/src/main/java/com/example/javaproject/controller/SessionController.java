package com.example.javaproject.controller;

import com.example.javaproject.entity.Session;
import com.example.javaproject.entity.Mentor;
import com.example.javaproject.entity.Student;
import com.example.javaproject.repository.SessionRepository;
import com.example.javaproject.repository.MentorRepository;
import com.example.javaproject.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionRepository sessionRepo;
    private final MentorRepository mentorRepo;
    private final StudentRepository studentRepo;

    public SessionController(SessionRepository sessionRepo, MentorRepository mentorRepo, StudentRepository studentRepo) {
        this.sessionRepo = sessionRepo;
        this.mentorRepo = mentorRepo;
        this.studentRepo = studentRepo;
    }

    // Display all sessions
    @GetMapping
    public String listSessions(Model model) {
        List<Session> sessions = sessionRepo.findAll();
        model.addAttribute("sessions", sessions);
        return "session-list"; // session-list.html
    }

    // Show form to book a new session
    @GetMapping("/new")
    public String showSessionForm(Model model) {
        model.addAttribute("session", new Session());
        model.addAttribute("mentors", mentorRepo.findAll());
        model.addAttribute("students", studentRepo.findAll());
        return "session-form"; // session-form.html
    }

    // Handle form submission
    @PostMapping("/save")
    public String saveSession(@ModelAttribute("session") Session session) {
        if (session.getMentorId() != null) {
            Mentor mentor = mentorRepo.findById(session.getMentorId()).orElse(null);
            session.setMentor(mentor);
        }
        if (session.getStudentId() != null) {
            Student student = studentRepo.findById(session.getStudentId()).orElse(null);
            session.setStudent(student);
        }
        sessionRepo.save(session);
        return "redirect:/sessions";
    }

    // Delete session by ID
    @GetMapping("/delete/{id}")
    public String deleteSession(@PathVariable Long id) {
        sessionRepo.deleteById(id);
        return "redirect:/sessions";
    }
}
