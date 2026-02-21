package com.example.Interview_Portal.Repository;

import com.example.Interview_Portal.Entity.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User_Repo extends JpaRepository <User_Entity,Long> {
    Optional<User_Entity> findByEmail(String email);
}
