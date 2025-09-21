package com.student.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.studentapp.models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, String> {

}
