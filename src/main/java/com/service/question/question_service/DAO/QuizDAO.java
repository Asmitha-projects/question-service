package com.service.question.question_service.DAO;

import com.service.question.question_service.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizDAO extends JpaRepository<Quiz,Integer> {

    Optional<Quiz> findAllById(Integer id);
}
