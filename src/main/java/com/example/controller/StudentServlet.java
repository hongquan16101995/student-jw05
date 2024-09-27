package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Student;
import com.example.model.Classes;
import com.example.service.StudentService;
import com.example.service.ClassesService;

import java.io.*;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();
    private ClassesService classesService = new ClassesService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createGet":
                createGetStudent(request, response);
                break;
            case "updateGet":
                updateGetStudent(request, response);
                break;
            case "deleteStudent":
                deleteStudent(request, response);
                break;
            case "sortStudent":
                sortByAge(request, response);
                break;
            case "findByClasses":
                findByClasses(request, response);
                break;
            case "detail":
                detailStudent(request, response);
                break;
            case "":
                displayAllStudent(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createPost":
                createPostStudent(request, response);
                break;
            case "updatePost":
                updatePostStudent(request, response);
                break;
            case "searchStudent":
                searchByName(request, response);
                break;
        }
    }

    private void displayAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("students", studentService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void createGetStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("classes", classesService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void updateGetStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/update.jsp");
        request.setAttribute("student", studentService.findById(id));
        request.setAttribute("classes", classesService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void createPostStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        int classesId = Integer.parseInt(request.getParameter("classes"));
        Classes classes = classesService.findById(classesId);
        studentService.createStudent(new Student(name, age, address, gender, classes));
        response.sendRedirect("/student/students");
    }

    private void updatePostStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        int classesId = Integer.parseInt(request.getParameter("classes"));
        Classes classes = classesService.findById(classesId);
        studentService.updateStudent(new Student(id, name, age, address, gender, classes));
        response.sendRedirect("/student/students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(id);
        response.sendRedirect("/student/students");
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("students", studentService.searchByName(name));
        request.setAttribute("nameSearch", name);
        requestDispatcher.forward(request, response);
    }

    private void sortByAge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("students", studentService.sortByAge(type));
        requestDispatcher.forward(request, response);
    }

    private void findByClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("students", studentService.findByClasses(classId));
        requestDispatcher.forward(request, response);
    }

    private void detailStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/detail.jsp");
        request.setAttribute("student", studentService.findById(id));
        requestDispatcher.forward(request, response);
    }
}
