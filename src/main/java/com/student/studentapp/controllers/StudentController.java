package com.student.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentapp.models.StudentModel;
import com.student.studentapp.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE - Add student
    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student) {
        return studentService.createStudent(student);
    }

    // READ - Get all students
    @GetMapping("/getall")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    // UPDATE - Update single student
    @PutMapping
    public StudentModel updateStudent(@RequestBody StudentModel student) {
        return studentService.updateStudent(student);
    }

    // DELETE - Delete by rollNo
    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable String rollNo) {
        studentService.deleteStudent(rollNo);
        return "Student deleted successfully";
    }

    // CREATE BULK
    @PostMapping("/bulk")
    public List<StudentModel> createBulkStudents(@RequestBody List<StudentModel> students) {
        return studentService.createBulkStudents(students);
    }

    // UPDATE BULK
    @PutMapping("/bulk")
    public List<StudentModel> updateBulkStudents(@RequestBody List<StudentModel> students) {
        return studentService.updateBulkStudents(students);
    }

    // DELETE BULK
    @DeleteMapping("/bulkdelete")
    public String deleteBulkStudents(@RequestBody List<String> rollNos) {
        studentService.deleteBulkStudents(rollNos);
        return "Students deleted successfully";
    }
}
