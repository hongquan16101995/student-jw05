package com.example.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.example.model.Classes;
import com.example.model.Student;

public class ClassesDAO {
    private final String SELECT_ALL_CLASSES = "select * from classes;";
    private final String SELECT_CLASSES = "select * from classes where id = ?;";
    private final String INSERT_INTO = "insert into classes(name, date_db) value (?,?);";
    private final String UPDATE_CLASSES = "update classes set name = ? where id = ?;";


    public ClassesDAO() {}

    public ArrayList<Classes> findAll() {
        ArrayList<Classes> classes = new ArrayList<>();
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate date = LocalDate.parse(resultSet.getString("date_db"));
                classes.add(new Classes(id, name, date));
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return classes;
    }

    public Classes findById(int id) {
        Classes classes = null;
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSES);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classes = new Classes(idDB, name);
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return classes;
    }

    public void createClasses(Classes classes) {
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, classes.getName());
            preparedStatement.setDate(2, Date.valueOf(classes.getDate().toString()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
    }

    public void updateClasses(Classes classes) {
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLASSES);
            preparedStatement.setString(1, classes.getName());
            preparedStatement.setInt(2, classes.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
    }
}
