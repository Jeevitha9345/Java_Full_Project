package com.example.Interview_Portal.Service;

import com.example.Interview_Portal.Entity.User_Entity;
import com.example.Interview_Portal.Repository.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth_Service {

    @Autowired
    private User_Repo userRepository;

    // REGISTER
    public String register(User_Entity user) {

        Optional<User_Entity> existing =
                userRepository.findByEmail(user.getEmail());

        if (existing.isPresent()) {
            return "User already exists";
        }

        userRepository.save(user);
        return "Success";
    }

    // LOGIN
    public String login(String email, String password) {

        Optional<User_Entity> user =
                userRepository.findByEmail(email);

        if (user.isEmpty()) {
            return "User not found";
        }

        if (!user.get().getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Success";
    }

    public User_Entity getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
}