package com.example.salao;

public class Client {
    private String nome;
    private String telefone;
    private String gmail;

    public Client(String nome, String telefone, String gmail) {
        this.nome = nome;
        this.telefone = telefone;
        this.gmail = gmail;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
