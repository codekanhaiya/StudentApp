package com.student.studentapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentapp.models.StudentModel;
import com.student.studentapp.repository.StudentRepository;

@Service
public class StudentService {
    // In-memory student list (for now, no DB)
    // private List<StudentModel> students = new ArrayList<>();

    @Autowired
    private StudentRepository studentRepository;

    // CREATE - add single student
    public StudentModel createStudent(StudentModel student) {
        // students.add(student);
        // return student;
        return studentRepository.save(student);
    }

    // READ - get all students
    public List<StudentModel> getAllStudents() {
        // return students;
        return studentRepository.findAll();
    }

    // UPDATE - update single student
    public StudentModel updateStudent(StudentModel student) {
        // for (int i = 0; i < students.size(); i++) {
        // if (students.get(i).getRollNo().equals(student.getRollNo())) {
        // students.set(i, student);
        // return student;
        // }
        // }
        // return null;
        return studentRepository.save(student);
    }

    // DELETE - delete by rollNo
    public void deleteStudent(String rollNo) {
        // students.removeIf(s -> s.getRollNo().equals(rollNo));
        studentRepository.deleteById(rollNo);
    }

    // CREATE - bulk students
    public List<StudentModel> createBulkStudents(List<StudentModel> newStudents) {
        // students.addAll(newStudents);
        // return newStudents;
        return studentRepository.saveAll(newStudents);
    }

    // UPDATE - bulk students
    public List<StudentModel> updateBulkStudents(List<StudentModel> updatedStudents) {
        // for (StudentModel s : updatedStudents) {
        // updateStudent(s); // reuse single update
        // }
        // return updatedStudents;
        return studentRepository.saveAll(updatedStudents);
    }

    // DELETE - bulk students
    public void deleteBulkStudents(List<String> rollNos) {
        // students.removeIf(s -> rollNos.contains(s.getRollNo()));
        rollNos.forEach(studentRepository::deleteById);
    }
}
