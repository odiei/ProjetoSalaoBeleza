package com.example.salao;

import java.util.ArrayList;

public class Administrator extends Employee {
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;

    public Administrator(String name, String position, double salary, String username, String password) {
        super(name, position, salary, username, password);
        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    // Métodos para gerenciar funcionários
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    // Métodos para gerenciar clientes
    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    // Getters e Setters
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}


