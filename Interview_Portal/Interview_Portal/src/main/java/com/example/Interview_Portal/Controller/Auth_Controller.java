package com.example.Interview_Portal.Controller;

import com.example.Interview_Portal.Entity.User_Entity;
import com.example.Interview_Portal.Service.Auth_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class Auth_Controller {

    @Autowired
    private Auth_Service authService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User_Entity user) {

        Map<String, Object> response = new HashMap<>();

        String result = authService.register(user);

        if (result.equals("User already exists")) {
            response.put("success", false);
            response.put("message", "Email already registered!");
        } else {
            response.put("success", true);
            response.put("message", "Registration successful!");
        }
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String email,
                                     @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();
        String result = authService.login(email, password);
        if (result.equals("User not found")) {
            response.put("success", false);
            response.put("message", "User not found!");
        }
        else if (result.equals("Invalid password")) {
            response.put("success", false);
            response.put("message", "Incorrect password!");
        }
        else {
            response.put("success", true);
            response.put("message", "Login successful!");
        }
        return response;
    }
}