package com.antatrix.quiz_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.antatrix.quiz_services.feign.QuizInterface;
import com.antatrix.quiz_services.model.QuestionWrapper;
import com.antatrix.quiz_services.model.Quiz;
import com.antatrix.quiz_services.model.QuizDto;
import com.antatrix.quiz_services.model.Response;
import com.antatrix.quiz_services.repository.QuizRepository;

@Service
public class QuizService {

  @Autowired
  private QuizInterface quizInterface;
  @Autowired
  private QuizRepository quizRepository;

  public ResponseEntity<String> createQuiz(QuizDto quizDto) {
    String category = quizDto.getCategory();
    Integer noOfQuestions = quizDto.getNoOfQuestions();
    String title = quizDto.getTitle();
    List<Integer> questionIds = quizInterface.generateQuestions(category, noOfQuestions).getBody();
    Quiz quiz = new Quiz();
    quiz.setQuestionIds(questionIds);
    quiz.setTitle(title);
    quizRepository.save(quiz);

    
    return new ResponseEntity("success", HttpStatusCode.valueOf(201));
  }

  public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getQuestions'");
  }

  public ResponseEntity<Integer> submitQuiz(List<Response> responses, Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'submitQuiz'");
  }

}
