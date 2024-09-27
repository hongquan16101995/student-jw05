package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.model.Student;
import com.example.model.Classes;
import com.example.service.ClassesService;
import com.example.DAO.MyConnection;

public class StudentDAO {
    private final String SELECT_ALL_STUDENT = "select * from student;";
    private final String SELECT_STUDENT = "select * from student where id = ?;";
    private final String INSERT_INTO = "insert into student(name, age, address, gender, classId) value (?,?,?,?,?);";
    private final String UPDATE_STUDENT = "update student set name = ?, age = ?, address = ?, gender = ?, classId = ? where id = ?;";
    private final String DELETE_STUDENT = "delete from student where id = ?;";
    private final String SEARCH_BY_NAME_STUDENT = "select * from student where name like ?;";
    private final String SORT_BY_AGE_ASC = "select * from student order by age asc;";
    private final String SORT_BY_AGE_DESC = "select * from student order by age desc;";
    private final String SELECT_STUDENT_BY_CLASSES = "select * from student where classId = ?;";
    private ClassesService classesService = new ClassesService();

    public StudentDAO() {}

    public ArrayList<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                int classId = resultSet.getInt("classId");
                Classes classes = classesService.findById(classId);
                students.add(new Student(id, name, age, address, gender, classes));
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return students;
    }

    public Student findById(int id) {
        Student student = null;
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                int classId = resultSet.getInt("classId");
                Classes classes = classesService.findById(classId);
                student = new Student(idDB, name, age, address, gender, classes);
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return student;
    }

    public void createStudent(Student student) {
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setInt(5, student.getClasses().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setInt(5, student.getClasses().getId());
            preparedStatement.setInt(6, student.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME_STUDENT);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameDB = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                int classId = resultSet.getInt("classId");
                Classes classes = classesService.findById(classId);
                students.add(new Student(id, nameDB, age, address, gender, classes));
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return students;
    }

    public ArrayList<Student> sortByAge(String type) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "";
        if (type.equals("ASC")) {
            sql = SORT_BY_AGE_ASC;
        } else {
            sql = SORT_BY_AGE_DESC;
        }
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                int classId = resultSet.getInt("classId");
                Classes classes = classesService.findById(classId);
                students.add(new Student(id, name, age, address, gender, classes));
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return students;
    }

    public ArrayList<Student> findByClasses(int classId) {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = MyConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_CLASSES);
            preparedStatement.setInt(1, classId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                Classes classes = classesService.findById(classId);
                students.add(new Student(idDB, name, age, address, gender, classes));
            }
        } catch (Exception e) {
            System.out.println("Có lỗi:" + e.getMessage());
        }
        return students;
    }
}
