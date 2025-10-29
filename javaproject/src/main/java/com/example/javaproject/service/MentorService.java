package com.example.javaproject.service;

import com.example.javaproject.entity.Mentor;
import com.example.javaproject.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepo;

    public MentorService(MentorRepository mentorRepo) {
        this.mentorRepo = mentorRepo;
    }

    public List<Mentor> getAllMentors() {
        return mentorRepo.findAll();
    }

    public void addMentor(Mentor mentor) {
        mentorRepo.save(mentor);
    }
}
