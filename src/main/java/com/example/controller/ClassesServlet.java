package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Classes;
import com.example.service.ClassesService;

import java.io.*;

@WebServlet(name = "ClassesServlet", value = "/classes")
public class ClassesServlet extends HttpServlet {
    private ClassesService classesService = new ClassesService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createGet":
                createGetClasses(request, response);
                break;
            case "updateGet":
                updateGetClasses(request, response);
                break;
            case "":
                displayAllClasses(request, response);
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
                createPostClasses(request, response);
                break;
            case "updatePost":
                updatePostClasses(request, response);
                break;
        }
    }

    private void displayAllClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("classes/list.jsp");
        request.setAttribute("classes", classesService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void createGetClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("classes/create.jsp");
    }

    private void updateGetClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("classes/update.jsp");
        request.setAttribute("classes", classesService.findById(id));
        requestDispatcher.forward(request, response);
    }

    private void createPostClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        classesService.createClasses(new Classes(name, date));
        response.sendRedirect("/student/classes");
    }

    private void updatePostClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        classesService.updateClasses(new Classes(id, name));
        response.sendRedirect("/student/classes");
    }
}
