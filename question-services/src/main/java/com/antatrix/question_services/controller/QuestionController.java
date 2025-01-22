package com.antatrix.question_services.controller;

import org.springframework.web.bind.annotation.RestController;

import com.antatrix.question_services.model.Question;
import com.antatrix.question_services.model.QuestionWrapper;
import com.antatrix.question_services.model.Response;
import com.antatrix.question_services.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("question") 
public class QuestionController {

  @Autowired
  QuestionService questionService;

  //get questions
  @GetMapping("allQuestions")
  public ResponseEntity<List<Question>> getAllQuestions() {
      return questionService.getAllQuestions();
  }
  

  //get question by category
  @GetMapping("category/{category}")
  public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
    return questionService.getQuestionByCategory(category);
  }

  //add question

  @PostMapping("add")
  public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
    return questionService.addQuestion(question);
  }

  //generate question
  @GetMapping("generate")
  public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String categorName, @RequestParam Integer noOfQuestions) {
    return questionService.getQuestionsForQuiz(categorName, noOfQuestions);
  }

  //get question based on question_id
  @PostMapping("getQuestions")
  public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionsIds) {
   
      return questionService.getQuestions(questionsIds);
  }
  

  //getscore
  @PostMapping("getScore")
  public ResponseEntity<Integer> getScore(@RequestBody List<Response> response) {
      
      return questionService.getScore(response);
  }
  

}
