package com.antatrix.quiz_services.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.antatrix.quiz_services.model.QuestionWrapper;
import com.antatrix.quiz_services.model.Response;

@FeignClient(name = "QUESTION-SERVICES")
public interface QuizInterface {

  
  @GetMapping("question/generate")
  public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String categorName, @RequestParam Integer noOfQuestions);

  //get question based on question_id
  @PostMapping("question/getQuestions")
  public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionsIds) ;
  

  //getscore
  @PostMapping("question/getScore")
  public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);

}
