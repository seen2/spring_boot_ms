package com.antatrix.question_services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.antatrix.question_services.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

  // findByCategory
  public List<Question> findByCategory(String category);

  // generateQuestions
  @Query("SELECT a.id FROM Question a WHERE a.category = :categorName ORDER BY RAND() LIMIT :noOfQuestions")
  public List<Integer> getQuestionsForQuiz(String categorName, int noOfQuestions);

  // getQuestion
  public Optional<Question> findById(Integer questionId);

  


}
