package com.example.Interview_Portal.Service;

import com.example.Interview_Portal.Entity.Question_Entity;
import com.example.Interview_Portal.Repository.Question_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Question_Service {

    @Autowired
    private Question_Repo questionRepo;

    // 🔥 Save Question
    public Question_Entity saveQuestion(Question_Entity question) {
        return questionRepo.save(question);
    }

    // 🔥 Get Questions by Topic
    public List<Question_Entity> findByTopic(String topic) {
        return questionRepo.findByTopic(topic);
    }

    // 🔥 Check Answer
    public boolean checkAns(Long id, String userAns) {

        Question_Entity question = questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        return question.getCorrectOption().equalsIgnoreCase(userAns);
    }
}