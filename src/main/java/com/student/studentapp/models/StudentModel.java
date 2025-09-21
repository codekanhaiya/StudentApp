package com.student.studentapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentModel {

    @Id
    private String rollNo;
    private String name;
    private String course;

    public StudentModel(String rollNo, String name, String course){
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public StudentModel(){
        this.rollNo = null;
        this.name = null;
        this.course = null;
    }

    public String getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public String getCourse(){
        return course;
    }

    public void setRollNo(String rollNo){
        this.rollNo = rollNo;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCourse(String course){
        this.course = course;
    }

}
