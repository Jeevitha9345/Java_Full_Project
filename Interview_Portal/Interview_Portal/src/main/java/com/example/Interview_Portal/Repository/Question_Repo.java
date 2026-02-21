package com.example.Interview_Portal.Repository;

import com.example.Interview_Portal.Entity.Question_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Question_Repo extends JpaRepository<Question_Entity,Long> {
    List<Question_Entity> findByTopic(String topic);
}
