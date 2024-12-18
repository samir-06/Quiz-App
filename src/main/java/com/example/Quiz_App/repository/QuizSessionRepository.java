package com.example.Quiz_App.repository;




import com.example.Quiz_App.models.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> { }

