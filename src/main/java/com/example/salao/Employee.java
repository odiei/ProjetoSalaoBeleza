package com.example.salao;

public class Employee {
    private String name;
    private String position;
    private double salary;
    private String username;
    private String password;

    public Employee(String name, String position, double salary, String username, String password) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


