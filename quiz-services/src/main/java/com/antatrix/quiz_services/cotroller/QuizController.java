package com.antatrix.quiz_services.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antatrix.quiz_services.model.QuestionWrapper;
import com.antatrix.quiz_services.model.QuizDto;
import com.antatrix.quiz_services.model.Response;
import com.antatrix.quiz_services.services.QuizService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("quiz")
public class QuizController {

  @Autowired
  private QuizService quizService;

  // create quiz
  @PostMapping("create")
  public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
      return quizService.createQuiz(quizDto);
  }

  @GetMapping("get/{id}")
  public ResponseEntity<List<QuestionWrapper>> getMethodName(@PathVariable Integer id) {
      return quizService.getQuestions(id);
  }

  @PostMapping("submit/{id}")
  public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses, @PathVariable Integer id) {
      return quizService.submitQuiz(responses, id);
  }
  
  
  

}
