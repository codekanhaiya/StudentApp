package com.student.studentapp.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.studentapp.models.UserModel;
import com.student.studentapp.repository.UserRepository;

@Service
public class UserService {
     @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel authenticateUser(String username, String password) {
        Optional<UserModel> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }

        UserModel user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials! password didn't matche.");
        }

        return user;
    }

    public void initializeDefaultUsers() {
        // Create default admin user if not exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            UserModel admin = new UserModel();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }

        // Create default user if not exists
        if (userRepository.findByUsername("user").isEmpty()) {
            UserModel user = new UserModel();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setRole("USER");
            userRepository.save(user);
        }
    }
}
