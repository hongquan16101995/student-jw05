package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/jw05_student?useSSL=false&useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver: " + e.getMessage());
        }
        return connection; 
    }

}
