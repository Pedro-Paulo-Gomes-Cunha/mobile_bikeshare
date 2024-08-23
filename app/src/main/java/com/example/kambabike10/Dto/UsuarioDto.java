package com.example.kambabike10.Dto;

public class UsuarioDto {

    private String Nome;

    private String Login;

    private String Senha;
    private Double Saldo;

    private String Perfil;  //cliente /gerente / admin

    public UsuarioDto(String nome, String login, String senha, String perfil, Double _saldo) {
        Nome = nome;
        Login = login;
        Senha = senha;
        Perfil = perfil;
        Saldo=_saldo;
    }


    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double saldo) {
        this.Saldo = saldo;
    }

    public String getNome() {
        return this.Nome;
    }



    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getLogin() {
        return this.Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getPerfil() {
        return this.Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }


}
