package com.example.service;

import com.example.DAO.StudentDAO;
import java.util.ArrayList;

import com.example.model.Student;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public ArrayList<Student> findAll() {
        return this.studentDAO.findAll();
    }

    public Student findById(int id) {
        return this.studentDAO.findById(id);
    }

    public void createStudent(Student student) {
        this.studentDAO.createStudent(student);
    }

    public void updateStudent(Student student) {
        this.studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        this.studentDAO.deleteStudent(id);
    }

    public ArrayList<Student> searchByName(String name) {
        return this.studentDAO.searchByName(name);
    }

    public ArrayList<Student> sortByAge(String type) {
        return this.studentDAO.sortByAge(type);
    }

    public ArrayList<Student> findByClasses(int classId) {
        return this.studentDAO.findByClasses(classId);
    } 
}
