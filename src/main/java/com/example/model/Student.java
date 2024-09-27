package com.example.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private String gender;
    private Classes classes;

    public Student(int id, String name, int age, String address, String gender, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.classes = classes;
    }

    public Student(String name, int age, String address, String gender, Classes classes) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.classes = classes;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }  
    
    
}
