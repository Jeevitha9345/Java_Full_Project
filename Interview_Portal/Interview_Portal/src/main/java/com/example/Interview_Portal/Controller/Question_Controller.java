package com.example.Interview_Portal.Controller;

import com.example.Interview_Portal.Entity.Question_Entity;
import com.example.Interview_Portal.Repository.Question_Repo;
import com.example.Interview_Portal.Service.Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class Question_Controller {

    @Autowired
    private Question_Service questionService;

    @GetMapping("/{topic}/quiz")
    public List<Question_Entity> getQuizQuestions(@PathVariable String topic) {

        List<Question_Entity> questions = questionService.findByTopic(topic);
        Collections.shuffle(questions);

        return questions.stream().limit(5).toList();
    }

    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestParam Long id, @RequestParam String userAns){
        boolean res=questionService.checkAns(id,userAns);
        Map<String,Object> response=new HashMap<>();
        response.put("correct",res);
        if(res){
            response.put("message","Correct Answer!");
        }else{
            response.put("message","Wrong Answer!");
        }
        return response;
    }

    @PostMapping("/add")
    public Question_Entity addQuestion(@RequestBody Question_Entity question) {
        return questionService.saveQuestion(question);
    }

}