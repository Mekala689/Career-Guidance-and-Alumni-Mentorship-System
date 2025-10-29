package com.example.javaproject.controller;
import com.example.javaproject.service.MentorService;
import com.example.javaproject.entity.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MentorController {

    private final MentorService service;

    public MentorController(MentorService service) { this.service = service; }

    @GetMapping("/mentors")
    public String listMentors(Model model) {
        model.addAttribute("mentors", service.getAllMentors());
        return "mentors";
    }

    @GetMapping("/addMentor")
    public String addMentorForm(Model model) {
        model.addAttribute("mentor", new Mentor());
        return "addMentor";
    }

    @PostMapping("/addMentor")
    public String saveMentor(@ModelAttribute Mentor mentor) {
        service.addMentor(mentor);
        return "redirect:/mentors";
    }
}
