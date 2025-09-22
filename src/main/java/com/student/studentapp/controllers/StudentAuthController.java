package com.student.studentapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentAuthController {
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Hello, Student! This is public info for all logged-in users.";
    }

    @GetMapping("/profile")
    public String profileEndpoint() {
        return "Hello, Student! This is your profile info (user only).";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello, Admin! You have full access including admin info.";
    }
}
