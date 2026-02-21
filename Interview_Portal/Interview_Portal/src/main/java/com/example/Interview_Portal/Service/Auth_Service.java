package com.example.Interview_Portal.Service;

import com.example.Interview_Portal.Entity.User_Entity;
import com.example.Interview_Portal.Repository.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth_Service {
    @Autowired
    private User_Repo user_repo;
    public String register(User_Entity user){
        Optional<User_Entity> exist=user_repo.findByEmail((user.getEmail()));
        if(exist.isPresent()){
            return "User already exists";
        }
        user_repo.save(user);
        return "User registered successfully";
    }
    public String login(String email,String password){
        Optional<User_Entity> user=user_repo.findByEmail(email);
        if(user.isEmpty()) return "User not found";
        if(!user.get().getPassword().equals(password)){
            return "Invalid password";
        }
        return "Login successfully!";
    }
}
