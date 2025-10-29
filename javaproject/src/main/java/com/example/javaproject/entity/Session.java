package com.example.javaproject.entity;

import jakarta.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String date;

    @ManyToOne
    private Mentor mentor;

    @ManyToOne
    private Student student;

    @Transient
    private Long mentorId;

    @Transient
    private Long studentId;

    public Session() {}
    public Session(String topic, String date, Mentor mentor, Student student) {
        this.topic = topic;
        this.date = date;
        this.mentor = mentor;
        this.student = student;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public Mentor getMentor() { return mentor; }
    public void setMentor(Mentor mentor) { this.mentor = mentor; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Long getMentorId() { return mentorId; }
    public void setMentorId(Long mentorId) { this.mentorId = mentorId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}

