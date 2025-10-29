package com.example.javaproject.service;

import com.example.javaproject.entity.Session;
import com.example.javaproject.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepo;

    public SessionService(SessionRepository sessionRepo) {
        this.sessionRepo = sessionRepo;
    }


    public List<Session> getAllSessions() {
        return sessionRepo.findAll();
    }

    
    public void saveSession(Session session) {
        sessionRepo.save(session);
    }

    
    public Session getSessionById(Long id) {
        Optional<Session> optional = sessionRepo.findById(id);
        return optional.orElse(null);
    }

    
    public void deleteSession(Long id) {
        sessionRepo.deleteById(id);
    }
}
