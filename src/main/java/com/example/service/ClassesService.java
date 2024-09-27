package com.example.service;

import java.util.ArrayList;

import com.example.DAO.ClassesDAO;
import com.example.model.Classes;
import com.example.model.Student;

public class ClassesService {
    private ClassesDAO classesDAO;

    public ClassesService() {
        this.classesDAO = new ClassesDAO();
    }

    public ArrayList<Classes> findAll() {
        return this.classesDAO.findAll();
    }

    public Classes findById(int id) {
        return this.classesDAO.findById(id);
    }

        public void createClasses(Classes classes) {
        this.classesDAO.createClasses(classes);
    }

    public void updateClasses(Classes classes) {
        this.classesDAO.updateClasses(classes);
    }
}
