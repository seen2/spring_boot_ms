package com.antatrix.quiz_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antatrix.quiz_services.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
