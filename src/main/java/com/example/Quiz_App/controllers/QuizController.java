package com.example.Quiz_App.controllers;




import com.example.Quiz_App.models.Question;
import com.example.Quiz_App.models.QuizSession;
import com.example.Quiz_App.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startNewSession() {
        return quizService.startNewSession();
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public QuizSession submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String selectedOption) {
        return quizService.submitAnswer(sessionId, questionId, selectedOption);
    }

    @GetMapping("/summary")
    public QuizSession getSessionSummary(@RequestParam Long sessionId) {
        return quizService.getSessionSummary(sessionId);
    }
}
