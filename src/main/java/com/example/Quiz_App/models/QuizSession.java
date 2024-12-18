package com.example.Quiz_App.models;

import jakarta.persistence.*;



@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalQuestions;
    private int correctAnswers;


    public void setIncorrectAnswers(Long incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    private Long incorrectAnswers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return Math.toIntExact(incorrectAnswers);
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = (long) incorrectAnswers;
    }


}

