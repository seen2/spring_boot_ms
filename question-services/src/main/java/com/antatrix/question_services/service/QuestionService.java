package com.antatrix.question_services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.antatrix.question_services.model.Question;
import com.antatrix.question_services.model.QuestionWrapper;
import com.antatrix.question_services.model.Response;
import com.antatrix.question_services.repository.QuestionRepository;

@Service
public class QuestionService {

  @Autowired
  QuestionRepository questionRepository;

  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      return ResponseEntity.ok(questionRepository.findAll());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
  // get question by category

  public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
    try {
      return ResponseEntity.ok(questionRepository.findByCategory(category));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  // add question

  public ResponseEntity<Question> addQuestion(Question question) {
    try {
      return ResponseEntity.ok(questionRepository.save(question));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  // generate question

  public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categorName, int noOfQuestions) {
    try {
      return ResponseEntity.ok(questionRepository.getQuestionsForQuiz(categorName, noOfQuestions));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> questionsId) {
    try {
      List<QuestionWrapper> questionWrappers = new ArrayList<>();
      List<Question> questions = new ArrayList<>();
      questionsId.forEach(questionId -> {
        Optional<Question> question = questionRepository.findById(questionId);
        question.ifPresent(q->questions.add(q));
      });
      questions.forEach(question -> {
        QuestionWrapper questionWrapper = new QuestionWrapper();
        questionWrapper.setId(question.getId());
        questionWrapper.setQuestionTitle(question.getQuestionTitle());
        questionWrapper.setOption1(question.getOption1());
        questionWrapper.setOption2(question.getOption2());
        questionWrapper.setOption3(question.getOption3());
        questionWrapper.setOption4(question.getOption4());
        questionWrappers.add(questionWrapper);
      });
      return ResponseEntity.ok(questionWrappers);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<Integer> getScore(List<Response> response) {
    try {
      AtomicInteger score = new AtomicInteger(0);;
      response.forEach(res -> {
        Optional<Question> question = questionRepository.findById(res.getId());
        question.ifPresent(q -> {
          if (q.getRightAnswer().equals(res.getResponse())) {
            score.incrementAndGet();
          }
        });
      });
      return ResponseEntity.ok(Integer.valueOf(score.get()));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

}
