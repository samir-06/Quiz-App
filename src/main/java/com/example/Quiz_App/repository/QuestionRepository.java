package com.example.Quiz_App.repository;




import com.example.Quiz_App.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> { }

