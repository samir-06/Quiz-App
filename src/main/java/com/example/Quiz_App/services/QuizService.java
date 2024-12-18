package com.example.Quiz_App.services;




import com.example.Quiz_App.models.Question;
import com.example.Quiz_App.models.QuizSession;
import com.example.Quiz_App.repository.QuestionRepository;
import com.example.Quiz_App.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startNewSession() {
        QuizSession session = new QuizSession();
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public QuizSession submitAnswer(Long sessionId, Long questionId, String selectedOption) {
        Optional<QuizSession> optionalSession = quizSessionRepository.findById(sessionId);
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);


        if (optionalSession.isEmpty() || optionalQuestion.isEmpty()) {
            throw new RuntimeException("Invalid session or question ID");
        }
        QuizSession session = optionalSession.get();
        Question question = optionalQuestion.get();

        session.setTotalQuestions(session.getTotalQuestions() + 1);
        if (question.getCorrectOption().equals(selectedOption)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        return quizSessionRepository.save(session);
    }

    public QuizSession getSessionSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
}

