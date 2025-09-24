package com.student.studentapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.studentapp.models.UserModel;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, String>{
    Optional<UserModel> findByUsername(String username);
}
