package com.example.model;

import java.time.LocalDate;

public class Classes {
    private int id;
    private String name;
    private LocalDate date;

    public Classes(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Classes(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Classes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Classes(String name) {
        this.name = name;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
