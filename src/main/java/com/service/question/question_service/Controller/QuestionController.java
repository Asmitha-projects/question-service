package com.service.question.question_service.Controller;

import com.service.question.question_service.DAO.QuestionDao;
import com.service.question.question_service.Question;
import com.service.question.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }
    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
}
