package com.ritesh.studyhabitanalyzer.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class StudySession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String subject;


    private double hours;


    private int productivity;


    private LocalDate studyDate;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    // Default Constructor

    public StudySession() {

    }



    // Getters and Setters


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }



    public double getHours() {
        return hours;
    }


    public void setHours(double hours) {
        this.hours = hours;
    }



    public int getProductivity() {
        return productivity;
    }


    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }



    public LocalDate getStudyDate() {
        return studyDate;
    }


    public void setStudyDate(LocalDate studyDate) {
        this.studyDate = studyDate;
    }



    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

}