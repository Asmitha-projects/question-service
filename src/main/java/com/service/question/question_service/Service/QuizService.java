package com.service.question.question_service.Service;

import com.service.question.question_service.DAO.QuestionDao;
import com.service.question.question_service.DAO.QuizDAO;
import com.service.question.question_service.Model.Question;
import com.service.question.question_service.Model.QuestionWrapper;
import com.service.question.question_service.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDAO quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz = quizDao.findAllById(id);
       List<Question> questionsFromDb = quiz.get().getQuestions();
       List<QuestionWrapper> questionForUser = new ArrayList<>();
       for (Question q: questionsFromDb){
           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionForUser.add(qw);
       }
       return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}
