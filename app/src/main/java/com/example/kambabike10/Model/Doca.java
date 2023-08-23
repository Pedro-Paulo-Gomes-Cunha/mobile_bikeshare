package com.example.kambabike10.Model;

public class Doca {
    int Id;
    String Nome;
    int Status;
    String Estacao;

    public Doca(int id, String nome, int status, String estacao, String bonus) {
        Id = id;
        Nome = nome;
        Status = status;
        Estacao = estacao;
        Bonus = bonus;
    }

    String Bonus;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getEstacao() {
        return Estacao;
    }

    public void setEstacao(String estacao) {
        Estacao = estacao;
    }

    public String getBonus() {
        return Bonus;
    }

    public void setBonus(String bonus) {
        Bonus = bonus;
    }
}
