package com.service.question.question_service.Service;

import com.service.question.question_service.DAO.QuestionDao;
import com.service.question.question_service.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion(){
        return questionDao.findAll();
    }

    public List<Question> getAllQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }
}
