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

  @SuppressWarnings({ "rawtypes", "unchecked" })
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
    List<Integer> questionIds = quizRepository.findById(id).get().getQuestionIds();
    ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestions(questionIds);
    return questions;
  }

  public ResponseEntity<Integer> submitQuiz(List<Response> responses, Integer id) {
    ResponseEntity<Integer> score = quizInterface.getScore(responses);
    return score;
  }

}
